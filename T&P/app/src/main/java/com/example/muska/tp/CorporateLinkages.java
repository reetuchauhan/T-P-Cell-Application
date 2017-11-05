package com.example.muska.tp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CorporateLinkages extends AppCompatActivity {

    ListView list;
    String[] web = {
            "  Accenture",
            "  Ahuliwala",
            "  Alstom",
            "  Areva",
            "  Bhel",
            "  Birlasoft",
            "  Canon",
            "  CMC Limited",
            "  CSC",
            "  E Gateway",
            "  Eicher",
            "  GDA Technologies",
            "  HAL",
            "  HCL Infosystems LTD",
            "  Hindustan Uniliver Limited",
            "  I-flex Solutions",
            "  Infosys",
            "  Jaypee Group",
            "  Reliance Companies",
            "  Rockwell Automation",
            "  Sahara",
            "  Saraswati Dyanamic",
            "  Shriram Pistons and Rings Limited",
            "  Siemens",
            "  ST Microelectronics",
            "  Syntel Consider IT Done",
            "  Tata Consultancy Services",
            "  Tech Mahindra",
            "  TeleSoft",
            "  The Scooters India",
            "  Videocon",
            "  Wipro",
            "  Xansas",
            "  Yash Papers Limited"
    } ;
    Integer[] imageId = {
            R.drawable.accenture,
            R.drawable.ahuliwalia,
            R.drawable.alstom,
            R.drawable.arevalogo,
            R.drawable.bhel,
            R.drawable.birlasoft,
            R.drawable.canon_logo,
            R.drawable.cmc,
            R.drawable.csc,
            R.drawable.egateway,
            R.drawable.eicher,
            R.drawable.gda,
            R.drawable.hal,
            R.drawable.hclinfosystems,
            R.drawable.hlllogo,
            R.drawable.iflex,
            R.drawable.infosys,
            R.drawable.jp,
            R.drawable.reliance,
            R.drawable.rockwell,
            R.drawable.sahara,
            R.drawable.shriram,
            R.drawable.siemenslogo,
            R.drawable.stlogo,
            R.drawable.syntel,
            R.drawable.tcs,
            R.drawable.techmahindralogo,
            R.drawable.telesoft,
            R.drawable.th_scooters_india,
            R.drawable.videocon,
            R.drawable.wipro,
            R.drawable.xansas,
            R.drawable.yashlogo


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corporate_linkages);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Custom_List adapter = new
                Custom_List(CorporateLinkages.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(CorporateLinkages.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });
    }

}
