package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.network.Slack;
import nyc.c4q.ramonaharrison.network.response.Response;
import org.json.simple.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Bot myBot = new Bot();

        myBot.testApi();

        myBot.listChannels();

        myBot.listMessages(Slack.BOTS_CHANNEL_ID);

        // Post "Hello, world!" to the #bots channel
        //myBot.sendMessage("Hello, world!");


        myBot.sendMessageToBotsChannel("Test");
        myBot.sendMessageToBotsChannel("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");


//        myBot.sendMessageToBotsChannel("Wayne, Quana, Anas and Tech Tai are in da house!! We in da house!!");


        //I want to see how this works

        // Post a pineapple photo to the #bots channel
        //myBot.sendMessage("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");

    }
}