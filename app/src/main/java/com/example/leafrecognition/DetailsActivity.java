package com.example.leafrecognition;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView title;
    TextView sub_title;
    TextView slide_description;
    ImageView image;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();
        dataload();
        action();
    }

    private void action() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void init() {
        title = (TextView) findViewById(R.id.title);
        sub_title = (TextView) findViewById(R.id.sub_title);
        slide_description = (TextView) findViewById(R.id.slide_description);
        image = (ImageView) findViewById(R.id.image);
        back = (ImageView) findViewById(R.id.back);
    }

    private void dataload() {
        switch (getIntent().getStringExtra("leaf")) {
            case "strawberry":
                title.setText("Strawberry Leaf");
                sub_title.setText("Fragaria Ananassa");
                slide_description.setText("Strawberry, (genus Fragaria), genus of more than 20 species of flowering plants in the rose family (Rosaceae) and their edible fruit. Strawberries are native to the temperate regions of the Northern Hemisphere, and cultivated varieties are widely grown throughout the world. The fruits are rich in vitamin C and are commonly eaten fresh as a dessert fruit, are used as a pastry or pie filling, and may be preserved in many ways. Strawberry shortcake—made of fresh strawberries, sponge cake, and whipped cream—is a traditional American dessert.\n\nPhysical Description\nStrawberries are low-growing herbaceous plants with a fibrous root system and a crown from which arise basal leaves. The leaves are compound, typically with three leaflets, sawtooth-edged, and usually hairy. The flowers, generally white, rarely reddish, are borne in small clusters on slender stalks arising, like the surface-creeping stems, from the axils of the leaves. As a plant ages, the root system becomes woody, and the “mother” crown sends out runners (e.g., stolons) that touch ground and root, thus enlarging the plant vegetatively. Botanically, the strawberry fruit is considered an “accessory fruit” and is not a true berry. The flesh consists of the greatly enlarged flower receptacle and is embedded with the many true fruits, or achenes, which are popularly called seeds.\n\nCultivated\nThe cultivated large-fruited strawberry (Fragaria ×ananassa) originated in Europe in the 18th century. Most countries developed their own varieties during the 19th century, and those are often specially suitable for the climate, day length, altitude, or type of production required in a particular region. Strawberries are produced commercially both for immediate consumption and for processing as frozen, canned, or preserved berries or as juice. Given the perishable nature of the berries and the unlikelihood of mechanical picking, the fruit is generally grown near centres of consumption or processing and where sufficient labour is available. The berries are handpicked directly into small baskets and crated for marketing or put into trays for processing. Early crops can be produced under glass or plastic covering. Strawberries are very perishable and require cool dry storage.");
                image.setImageResource(R.drawable.strawberry);
                break;
            case "blueberry":
                title.setText("Blueberry Leaf");
                sub_title.setText("Cyanococcus");
                slide_description.setText("Blueberries are perennial flowering plants with blue or purple berries. They are classified in the section Cyanococcus within the genus Vaccinium. Vaccinium also includes cranberries, bilberries, huckleberries and Madeira blueberries.[1] Commercial blueberries—both wild (lowbush) and cultivated (highbush)—are all native to North America. The highbush varieties were introduced into Europe during the 1930s.[2]\n" +
                        "\n" +
                        "Blueberries are usually prostrate shrubs that can vary in size from 10 centimeters (4 inches) to 4 meters (13 feet) in height. In commercial production of blueberries, the species with small, pea-size berries growing on low-level bushes are known as \"lowbush blueberries\" (synonymous with \"wild\"), while the species with larger berries growing on taller cultivated bushes are known as \"highbush blueberries\". Canada is the leading producer of lowbush blueberries, while the United States produces some 40% of the world supply of highbush blueberries.");
                image.setImageResource(R.drawable.blueberry);
                break;


        }
    }

}