package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.network.Slack;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    public static void main(String[] args) throws JSONException, IOException {

        Bot myBot = new Bot();

        myBot.testApi();

        myBot.listChannels();

        myBot.listMessages(Slack.BOTS_CHANNEL_ID);

        Bot myBotTest = new Bot();

        myBotTest.testApiMyBot();

        myBotTest.listChannelsMyBot();

        myBotTest.listMessagesMyBot(Slack.IM_CHANNEL);

//        HttpGet request = new HttpGet("https://hooks.slack.com/services/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");
//        HttpResponse response = client.execute(request);

        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("content-type", "application/json");
//        System.out.println(jsonObject.get("content-type"));
        jsonObject.put("text", "hello darkness my old friend");


        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://hooks.slack.com/services/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");
        StringEntity postingString = new StringEntity(jsonObject.toString());//gson.tojson() converts your pojo to json
        post.setEntity(postingString);
        post.setHeader("Content-type", "application/json");
        HttpResponse  response = client.execute(post);


        final JSONObject obj = new JSONObject(JSON_DATA);
        final JSONArray geodata = obj.getJSONArray("geodata");
        final int n = geodata.length();
        for (int i = 0; i < n; ++i) {
            final JSONObject person = geodata.getJSONObject(i);
            System.out.println(person.getInt("id"));
            System.out.println(person.getString("name"));
            System.out.println(person.getString("gender"));
            System.out.println(person.getDouble("latitude"));
            System.out.println(person.getDouble("longitude"));
        }




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