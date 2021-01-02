package org.techtown.movie;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    RecyclerView recyclerView;
    MovieAdapter adapter;

    static RequestQueue requestQueue;

    String[] URLs =
            {
                    "https://w.namu.la/s/fcf83e3c2b180f6fe1adabda6d121cedf890d68e1357ebb3b1cf463297fa723ad5989666a126b4fad44f02633cd2f56c5468418c132a62ad119e5b9f20c3451c89462e94c43e0f91ec8f0a3af3c528b97b64b1bc91cd818053e1517c1c655841e171f2e27d231a901e1b6695cbc07f69"
                    , "https://ww.namu.la/s/5c4cef239cdc13ca65a74cf9733347c21f2ef560ab7cdc3f857019b161cd263c18d4ab7a390a91820bff602d01507b4904cb7995ec3dd2ffdd45d6c51e8c616aff8cd29ea70324a511f80b4424fc53b5cc8fc00a82fb469e4f8222044d78058e0e5fa43bd89afc9de782e762a590c33f"
                    , "https://ww.namu.la/s/e3131845b6381a07f3ec16cdfaebe86a5f551dda2384a476b89cd2a424fced013272c51493eabc7e12fb09bc292c5573d72664d895b162dc48032e6f810d94efd8940f58b2a3c716dd2ef5623f25099025dd52b9521e30bb1febd550923f0eb2cb2d27e5801ebe9d5ac7af56bf3c003d"
                    , "https://w.namu.la/s/e38dc0881c189d4241549d4c40c505809e6d82fdf98d24efcdb585bc8a57215369cd8c96032658023e3a8434101bb64250574decb131a3587c1d1d8fc8d188f76ff1ddef75b830749c75816affbdcd35e59e990a5139625aaba85bea76f2260579310b4c1a1abd78076c7026104d51e2"
                    , "https://w.namu.la/s/21449ef5d92a9ac91cfe9e9fe023356b26f60865791382414197a89bc1b23f86153d503998a4991dd091a94ac5fe3799bef8c1f44908fc73f74a50dcda0fd13e29585997fef565a4c08f530c17f1c95e0cc48211be01919608bbd05be6adf85da32cdb4fec8b73416692b42330aecf14"
                    , "https://w.namu.la/s/40d19f00c3e8df9be954761b010ef8dd777a0f72a884b14e592bba662d20664d94adab1f79c70f3f29a79df821628c6b815c8588b837c613af7ed946cfdb2f8b7d025aa49dec9c350a957e05efbf09c74c5e0a9d5fa649f9cc185686377882e5fa11dd7f16eef77da8427d0abfa495d9"
                    , "https://ww.namu.la/s/a35feb3674526a1cea574887f9c1013d83548e29a01923bbd50358c43481ce169518252a9b6971c0469c958ed835ac2cb5e77f0153f192f7e86787cf9d758608d74f93a73e6dec4700f3448ad8c34de35b53a6c344949fbcf6d992e704fd8a1fbfb4c0352f89ced4084e0c0d700da8e1"
                    , "https://w.namu.la/s/d33342b7614c5aff67bddbd1104fd8045a35e9e4836cc56b5c3c5227baf51e905fec8400c4ed1221c763ab872ece8143cc0da39ba0b7b9a8db38a52e65b0d545fb717004b396c858bfe041cdbbb0df850fea402d7573e92465259309600fa9d519055824319c4e880f5adbcaa937f604"
                    , "https://w.namu.la/s/44d0943349b4d3f9c3bb963cab9218f1fcd398dfed9a819217992696b16de84289cf454305e75a6204426ea290eab8b6634f36fa3ecfec7afb8ef5efe2034d383e3047d0a211f75f20714a1051287e360580fec54419dc12e765d60df070113378f1bfcc746d57f0a0f561f8dd5ce3ac"
                    , "https://w.namu.la/s/d33342b7614c5aff67bddbd1104fd8045a35e9e4836cc56b5c3c5227baf51e905fec8400c4ed1221c763ab872ece8143cc0da39ba0b7b9a8db38a52e65b0d545fb717004b396c858bfe041cdbbb0df850fea402d7573e92465259309600fa9d519055824319c4e880f5adbcaa937f604"
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeRequest();
            }
        });

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MovieAdapter();
        recyclerView.setAdapter(adapter);
    }

    public void makeRequest() {
        String url = editText.getText().toString();

        StringRequest request = new StringRequest(
                Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        println("응답-> " + response);

                        processResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println("에러-> " + error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                return params;
            }
        };

        request.setShouldCache(false);
        requestQueue.add(request);

        println("요청 보냄.");
    }

    public void println(String data)
    {
        Log.d("MainActivity", data);
    }

    public void processResponse(String response)
    {
        Gson gson = new Gson();

        MovieList movieList = gson.fromJson(response, MovieList.class);

        println("영화 정보 수 : " + movieList.boxOfficeResult.dailyBoxOfficeList.size());

        for (int i = 0; i < movieList.boxOfficeResult.dailyBoxOfficeList.size(); i++)
        {
            Movie movie = movieList.boxOfficeResult.dailyBoxOfficeList.get(i);

            movie.imageUrl = URLs[i];

            adapter.addItem(movie);
        }

        adapter.notifyDataSetChanged();
    }
}