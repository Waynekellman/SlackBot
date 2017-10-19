package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.network.Slack;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import nyc.c4q.ramonaharrison.JSONparser;


import java.io.IOException;


public class Main {
    private final static String JSON_DATA =
            "{"
                    + "  \"geodata\": ["
                    + "    {"
                    + "      \"id\": \"1\","
                    + "      \"name\": \"Julie Sherman\","
                    + "      \"gender\" : \"female\","
                    + "      \"latitude\" : \"37.33774833333334\","
                    + "      \"longitude\" : \"-121.88670166666667\""
                    + "    },"
                    + "    {"
                    + "      \"id\": \"2\","
                    + "      \"name\": \"Johnny Depp\","
                    + "      \"gender\" : \"male\","
                    + "      \"latitude\" : \"37.336453\","
                    + "      \"longitude\" : \"-121.884985\""
                    + "    }"
                    + "  ]"
                    + "}";
    private static JSONObject jObject = null;

    public static void main(String[] args) throws JSONException, IOException, ParseException {

        /*Bot myBot = new Bot();

        myBot.testApi();

        myBot.listChannels();

        myBot.listMessages(Slack.BOTS_CHANNEL_ID);

        Bot myBotTest = new Bot();

        myBotTest.testApiMyBot();

        myBotTest.listChannelsMyBot();

        myBotTest.listMessagesMyBot(Slack.IM_CHANNEL);
        System.out.println();*/

//        HttpGet request = new HttpGet("https://hooks.slack.com/services/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");
//        HttpResponse response = client.execute(request);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content-type", "application/json");
        System.out.println(jsonObject.get("content-type"));
        jsonObject.put("text", "hello darkness my old friend");


        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://hooks.slack.com/services/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");
        StringEntity postingString = new StringEntity(jsonObject.toString());//gson.tojson() converts your pojo to json
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");
//        HttpResponse  response = client.execute(post);

//        HttpGet request = new HttpGet("https://guessbot.slack.com/messages/D7JQB8HMF/?code=256675766608.256826586913.9a158c253763c703b24bf74f94223e96a4c337cccb040d397904e1922f8f0fff&state=");
        String sURL = "https://guessbot.slack.com/messages/D7JQB8HMF/?code=256675766608.256826586913.9a158c253763c703b24bf74f94223e96a4c337cccb040d397904e1922f8f0fff&state="; //just a string

        String wURL = "https://hooks.slack.com/services/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";
        String url = "your url";
        JSONparser jsonParser = new JSONparser();
        JSONObject object = jsonParser.getJSONFromUrl(sURL);
//        String content=object.getString(Slack.IM_CHANNEL);

//        System.out.println(content);

        HttpPost post2 = new HttpPost("https://hooks.slack.com/services/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");
        StringEntity postingsString = new StringEntity(jsonObject.toString());//gson.tojson() converts your pojo to json
        post2.setEntity(postingsString);
        post2.setHeader("Content-type", "application/json");
        HttpResponse response = client.execute(post2);


//
//        final JSONObject obj = new JSONObject(JSON_DATA);
//        final JSONArray geodata = obj.getJSONArray("geodata");
//        final int n = geodata.length();
//        for (int i = 0; i < n; ++i) {
//            final JSONObject person = geodata.getJSONObject(i);
//            System.out.println(person.getInt("id"));
//            System.out.println(person.getString("name"));
//            System.out.println(person.getString("gender"));
//            System.out.println(person.getDouble("latitude"));
//            System.out.println(person.getDouble("longitude"));
//        }




//
//
//
//
//        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
//        StringBuffer result = new StringBuffer();
//
//        String line = "";
//        while((line = rd.readLine())!=null){
//            result.append(line);
//            System.out.println("response payload is " + result);
//        }



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