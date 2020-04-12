package com.example.project.services.corona;

import com.example.project.models.CoronaVirus;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoronaVirusService {
    private static String VIRUS_DATA_URL="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private List<CoronaVirus> allStats = new ArrayList<>();
    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public /*void*/ List<CoronaVirus> fetchVirusData() throws  InterruptedException, IOException {
        List<CoronaVirus> newStats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(VIRUS_DATA_URL))
                .build();
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        Integer brojac = 0;
        for (CSVRecord record : records) {
            brojac++;
            CoronaVirus coronaVirus = new CoronaVirus();
            coronaVirus.setId(brojac);
            coronaVirus.setState(record.get("Province/State"));
            coronaVirus.setCountry(record.get("Country/Region"));
            coronaVirus.setLatestTotalCases(Integer.parseInt(record.get(record.size() - 1)));
            //System.out.println(coronaVirus);
            newStats.add(coronaVirus);
        }
        this.allStats = newStats;
        return allStats;
    }

}
