package ie.cit.david.rugbywcapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Match;
import model.Round;
import model.Team;
import model.WorldCup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Team> teamsInQuarter= getTeamsFromLayoutQuarters();

                WorldCup wc= new WorldCup();
                Round qF= new Round();
                Match m1= new Match(teamsInQuarter.get(0),teamsInQuarter.get(1));
                Match m2= new Match(teamsInQuarter.get(2),teamsInQuarter.get(3));
                Match m3= new Match(teamsInQuarter.get(4),teamsInQuarter.get(5));
                Match m4= new Match(teamsInQuarter.get(6),teamsInQuarter.get(7));
                qF.addMatch(m1);
                qF.addMatch(m2);
                qF.addMatch(m3);
                qF.addMatch(m4);
                wc.setQuarterFinals(qF);
                List<Team> winnersToSemi= qF.playMatchesForRound();

                EditText text1 = (EditText) findViewById(R.id.team9);
                EditText text2 = (EditText) findViewById(R.id.team10);
                EditText text3 = (EditText) findViewById(R.id.team11);
                EditText text4 = (EditText) findViewById(R.id.team12);

                text1.setText(winnersToSemi.get(0).getName());
                text2.setText(winnersToSemi.get(1).getName());
                text3.setText(winnersToSemi.get(2).getName());
                text3.setText(winnersToSemi.get(3).getName());
            }
        });
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        CharSequence valueTime = savedInstanceState.getCharSequence("currentTime");
        Double time = new Double(valueTime.toString());

        Context context = getApplicationContext();
        Double timeMinimized = System.currentTimeMillis() - time;
        Toast myToast = Toast.makeText(context, timeMinimized.toString() + " ms", Toast.LENGTH_SHORT);
        myToast.show();
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putCharSequence("currentTime", System.currentTimeMillis() + "");
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event){
        for(int i=1; i<16;i++){
            String idTeam= "team"+i;
            Team theOne= null;
            int resID = getResources().getIdentifier(idTeam, "id", "ie.cit.david.rugbywcapp");
            EditText editText= (EditText)findViewById(resID);
            String stringTeam;
            if(editText.getText().length()==3){
                stringTeam= editText.getText().toString();
                if(getTeamFromName(stringTeam)!=null){
                    editText.setTextColor(Color.parseColor(getTeamFromName(stringTeam).getTeamColor()));
                }
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    private Team getTeamFromName(String name){
        Team result= null;
        Team[] allTeams= Team.values();
        List<Team> teams= Arrays.asList(allTeams);
        for(Team t: teams){
            if(t.getName().equals(name)){
                result = t;
            }
        }
        return result;
    }


    private List<Team> getTeamsFromLayoutQuarters(){
        List<Team> result= new ArrayList<>();
        for(int i=1;i<9;i++){
            String idTeam= "team"+i;
            int resID = getResources().getIdentifier(idTeam, "id", "ie.cit.david.rugbywcapp");
            EditText editText= (EditText)findViewById(resID);
            String stringTeam= editText.getText().toString();
            result.add(getTeamFromName(stringTeam));
        }
        return result;
    }



}
