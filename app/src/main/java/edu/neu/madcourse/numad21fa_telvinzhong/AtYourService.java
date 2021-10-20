package edu.neu.madcourse.numad21fa_telvinzhong;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

public class AtYourService extends AppCompatActivity {
    private static final String TAG = "At Your Service";

    private String zip1;
    private String zip2;
    private EditText boxOne;
    private EditText boxTwo;
    private TextView zipAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at_your_service);

        boxOne = findViewById(R.id.zipOne);
        boxTwo = findViewById(R.id.zipTwo);
    }

    public void startServiceButtonHandler(View view) {
        PingWebServiceTask task = new PingWebServiceTask();
        task.execute();
    }

    private class PingWebServiceTask extends AsyncTask<String, Integer, String> {
        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.i(TAG, "Making Progress...");
        }

        @Override
        protected String doInBackground(String... strings) {
            String result;
            URL url = null;
            zip1 = boxOne.getText().toString();
            zip2 = boxTwo.getText().toString();
            try {
                String urlString = "https://www.zipcodeapi.com/rest/gD6xmN7FNa6iSSpGvHD1YTBYpbSyBj6bLJdmLyMIAwuDCOiVvV3yKbmPLXbvNuE8/" +
                        "distance.json/" + zip1 + "/" + zip2 + "/mile";

                url = new URL(urlString);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.connect();

                InputStream inputStream = conn.getInputStream();
                final String response = convertStreamToString(inputStream);

                JSONObject jObject = new JSONObject(response);
                result = jObject.getString("distance");
                return result;

            } catch (MalformedURLException e) {
                Log.e(TAG, "MalformedURLException");
                e.printStackTrace();
            } catch (ProtocolException e) {
                Log.e(TAG, "Protocol Exception");
                e.printStackTrace();
            } catch (IOException e) {
                Log.e(TAG, "IOException");
                e.printStackTrace();
            } catch (JSONException e) {
                Log.e(TAG, "JSONException");
                e.printStackTrace();
            } catch (Exception e) {
                Log.e(TAG, "Exception");
                e.printStackTrace();
            }

            return "Something bad happened";
        }

        private String convertStreamToString(InputStream i) {
            Scanner s = new Scanner(i).useDelimiter("\\A");
            return s.hasNext() ? s.next().replace(",", ",\n") : "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            zipAnswer = (TextView) findViewById(R.id.zipAns);
            zipAnswer.setText(s + " miles");
        }
    }

}