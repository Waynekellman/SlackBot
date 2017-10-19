package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.network.Slack;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.Asserts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        Bot myBot = new Bot();

        myBot.testApi();

        myBot.listChannels();

        myBot.listMessages(Slack.BOTS_CHANNEL_ID);

        Bot myBotTest = new Bot();

        myBotTest.testApiMyBot();

        myBotTest.listChannelsMyBot();

        myBotTest.listMessagesMyBot(Slack.IM_CHANNEL);

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://hooks.slack.com/services/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");
        HttpResponse response = client.execute(request);

        


        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();

        String line = "";
        while((line = rd.readLine())!=null){
            result.append(line);
            System.out.println("response payload is " + result);
        }



//        client.execute("https://hooks.slack.com/services/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");



        // Post "Hello, world!" to the #bots channel
        //myBot.sendMessage("Hello, world!");


//        myBot.sendMessageToBotsChannel("Test");
//        myBot.sendMessageToBotsChannel("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");

//        myBot.sendMessageToBotsIMChannel("Test");



//        myBot.sendMessageToBotsChannel("Wayne, Quana, Anas and Tech Tai are in da house!! We in da house!!");


        //I want to see how this works

        // Post a pineapple photo to the #bots channel
        //myBot.sendMessage("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");

    }
}