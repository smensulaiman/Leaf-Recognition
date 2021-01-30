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
            case "potato":
                title.setText("Potato Leaf");
                sub_title.setText("Solanum tuberosum");
                slide_description.setText("The potato is a root vegetable native to the Americas, a starchy tuber of the plant Solanum tuberosum, and the plant itself is a perennial in the nightshade family, Solanaceae.[2]\n" +
                        "\n" +
                        "Wild potato species, originating in modern-day Peru, can be found throughout the Americas, from Canada to southern Chile.[3] The potato was originally believed to have been domesticated by indigenous peoples of the Americas independently in multiple locations,[4] but later genetic testing of the wide variety of cultivars and wild species traced a single origin for potatoes. In the area of present-day southern Peru and extreme northwestern Bolivia, from a species in the Solanum brevicaule complex, potatoes were domesticated approximately 7,000–10,000 years ago.[5][6][7] In the Andes region of South America, where the species is indigenous, some close relatives of the potato are cultivated.\n" +
                        "\n" +
                        "Potatoes were introduced to Europe from the Americas in the second half of the 16th century by the Spanish. Today they are a staple food in many parts of the world and an integral part of much of the world's food supply. As of 2014, potatoes were the world's fourth-largest food crop after maize (corn), wheat, and rice.[8]\n" +
                        "\n" +
                        "Following millennia of selective breeding, there are now over 5,000 different types of potatoes.[6] Over 99% of presently cultivated potatoes worldwide descended from varieties that originated in the lowlands of south-central Chile");
                image.setImageResource(R.drawable.potato);
                break;
            case "tomato":
                title.setText("Tomato Leaf");
                sub_title.setText("Solanum lycopersicum");
                slide_description.setText("Tomato plants are vines, initially decumbent, typically growing 180 cm (6 ft) or more above the ground if supported, although erect bush varieties have been bred, generally 100 cm (3 ft 3 in) tall or shorter. Indeterminate types are \"tender\" perennials, dying annually in temperate climates (they are originally native to tropical highlands), although they can live up to three years in a greenhouse in some cases. Determinate types are annual in all climates.[citation needed]\n" +
                        "\n" +
                        "Tomato plants are dicots, and grow as a series of branching stems, with a terminal bud at the tip that does the actual growing. When that tip eventually stops growing, whether because of pruning or flowering, lateral buds take over and grow into other, fully functional, vines.[9]\n" +
                        "\n" +
                        "Tomato vines are typically pubescent, meaning covered with fine short hairs. These hairs facilitate the vining process, turning into roots wherever the plant is in contact with the ground and moisture, especially if the vine's connection to its original root has been damaged or severed.");
                image.setImageResource(R.drawable.tomato);
                break;


        }
    }

}