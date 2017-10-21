package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.network.Slack;
import org.json.JSONException;
import org.json.simple.parser.ParseException;

import java.io.IOException;


public class Main {


    public static void main(String[] args) throws JSONException, IOException, ParseException {

        Bot myBot = new Bot();

        myBot.testApi();

        myBot.listChannels();

        myBot.listMessages(Slack.BOTS_CHANNEL_ID);


        myBot.sendMessageToBotsChannel("Hello darkness my old friend!!");

    }
}