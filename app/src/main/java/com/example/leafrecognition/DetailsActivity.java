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
            case "data shakh":
                title.setText("Data Shakh");
                sub_title.setText("Amaranthus Viridis");
                slide_description.setText("Amaranthus viridis is a cosmopolitan species in the botanical family Amaranthaceae and is commonly known as slender amaranth or green amaranth.");
                image.setImageResource(R.drawable.datasakh);
                break;
            case "neem":
                title.setText("Neem");
                sub_title.setText("Azadirachta Indica");
                slide_description.setText("Neem is a natural herb that comes from the neem tree, other names for which include Azadirachta indica and Indian lilac. \n" +
                        "The extract comes from the seeds of the tree and has many different traditional uses. Neem is known for its pesticidal and insecticidal properties, but people also use it in hair and dental products. \n" +
                        "Benefits:\n" +
                        "Neem oil is a common pest repellant, effective against sand fleas and mosquitoes. Other forms of neem can help control termites and repel moths. \n" +
                        "Some manufacturers add neem to animal shampoos to repel ticks and fleas. They may also add it to cattle feed or grain to repel pests and parasites.\n" +
                        "Neem is a strong antioxidant, neutralizing free radicals that may influence the development of some conditions. It is also a strong anti-inflammatory agent.\n" +
                        "Neem has antimicrobial effects and may be effective against several types of bacteria, viruses, and fungi.\n" +
                        "Uses:\n" +
                        "People most frequently use neem in hair and skin care products. Some people take neem extract capsules, but there is not currently enough research to say whether they have any medical benefits.\n" +
                        "The oil is yellow or brown and smells of garlic or sulfur. If ingested, it has a strong bitter taste.\n" +
                        "Dental products, including mouthwashes, toothpastes, and tooth powders, can also contain neem. Neem can reduce pain from toothache and improve dental health by cleaning the teeth and gums and alleviating gingivitis.\n" +
                        "\n" +
                        "Risks:\n" +
                        "Although experts generally consider neem safe for use, it is possible for someone to have an allergy or sensitivity to it.\n" +
                        "Before using neem for the first time, consider doing a patch test. To do a patch test, rub a few drops of neem onto a patch of skin on the inner forearm.\n" +
                        "Wait 24 hours, then look at the site to see whether a reaction has occurred. Any signs of discoloration, swelling, itching, or discomfort indicate that a person may be sensitive to the oil and should avoid using it again.\n" +
                        "In general, children are more sensitive to pesticides such as neem oil, though there is no research directly on the effects of neem in children.\n" +
                        "It is best to speak to a doctor before using any alternative medication on a child or during pregnancy.");
                image.setImageResource(R.drawable.neem);
                break;
            case "jasmine":
                title.setText("Jasmine");
                sub_title.setText("Jasminum");
                slide_description.setText("The jasmine plant is a genus of vines and shrubs from the olive family (botanical name Oleaceae).\n" +
                        "There are an impressive 200 species in existence, many of which are native to warm, tropical climates and regions including Australasia, Eurasia and Oceania. The main reason for this plant’s popularity is its characteristic fragrance. The jasmine flower is either deciduous (which means the leaves fall in the autumn) or evergreen (which means the leaves are green all year round).\n" +
                        "Certain species stand tall, while others spread or climb. The flowers typically measure 2.5 cm in diameter and boast hues of white and yellow. Certain species however are reddish in colour, although this is quite rare. The flowers are borne in cymose clusters and showcase at least three flowers. Each flower has between four and nine petals, four ovules and two locules. They have two stamens brandishing extremely short filaments, with linear or ovate bracts, with a bell-shaped calyx.\n" +
                        "Jasmine flowers also boast fruits in the shape of berries that change to black when ripe. Jasmine flowers are widely cultivated for their blooms, and are a popular garden and house plant.");
                image.setImageResource(R.drawable.jasmine);
                break;
            case "mint":
                title.setText("Mint");
                sub_title.setText("Mentha");
                slide_description.setText("Mint is a generic term for 'mentha plant' family. The most common and popular mints for cultivation are peppermint (Mentha × piperita), spearmint (Mentha spicata), and (more recently) apple mint. It is an aromatic herb widely used in the preparation of teas, beverages, jellies, syrups, candies, and ice creams.\n" +
                        "\n" +
                        "The mint leaf, fresh or dried, is the culinary source of mint. The leaf colors range from dark green and gray-green to purple, blue, and sometimes pale yellow. They are arranged in opposite pairs around a thin stem. The plant has wide-spreading underground rhizomes.\n" +
                        "\n" +
                        "Fresh mint is usually preferred over dried mint when storage of the mint is not a problem. Mint leaves have a pleasant, fresh, sweet flavor with a cool aftertaste. In India, mint is used to prepare peppy chutneys, raitas, stuffing etc. Mint leaves should be washed very well since the leaves and stems tend to collect sand and soil. Before washing, trim off the roots and separate the mint leaves. Put the washed leaves on a chopping board and chop them using a sharp knife into finely chopped or roughly chopped by cutting across the board. \n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "Health Benefits of pudina, mint leaves\n" +
                        "Treats Indigestion : Mint (pudina) being an anti-inflammatory reduces the inflammation in the stomach and shows a cleansing effect. The best effect is seen by chewing fresh mint leaves. This is because chewing mint activates the salivary glands which in turn produces digestive enzymes. This will help relieve indigestion and soothe your stomach.\n" +
                        "\n" +
                        "2. Aids Weight Loss : Mint (pudina) is a leafy vegetable which is sure to create nourishing dishes without piling on calories, carbs or fat for that instance. What is has to offer instead is FIBER. This nutrient profile in totality will help you achieve your weight loss target without any thought process.\n" +
                        "\n" +
                        "3. Safeguards Against Bad Breath : You have just gobbled on garlic soup or onion paratha, so what’s next you will do? Pop up a chewing gum or have mukhwas. Next time try chewing on some mint leaves. It will give you the same oral freshness as the mint chewing gum would lend.");
                image.setImageResource(R.drawable.mint);
                break;
            case "paan":
                title.setText("Paan");
                sub_title.setText("Piper betle");
                slide_description.setText("Betel leaf is a vine from the family of Piperaceae, mostly consumed in India and Asia as a ‘Paan’ along with ‘Arcea Nut’ or tobacco. While many look at it as ‘Paan’ consumed after a good meal or just as a habit, it also has a significant place during religious rituals in India.\n" +
                        "In India, the sheaf of betel leaves is offered to Gods, elders in the family as a mark of respect during festivals and functions. However, these glossy, heart-shaped leaves are often ignored for the huge amount of health benefits they offer to mankind.\n" +
                        "Known as ‘Paan Ka Patha’ in Hindi, Tamalapaaku in Telugu, Vethalapaaku in Tamil, Vattla in Malayalam, these leaves are not as bad as you imagined. Betel leaves come with several curative health benefits as they are loaded with vitamins like Vitamin C, thiamine, niacin, riboflavin, carotene and a great source of calcium.");
                image.setImageResource(R.drawable.paan);
                break;
            case "joba":
                title.setText("Joba");
                sub_title.setText("Hibiscus rosa-sinensis");
                slide_description.setText("Common names of this flower are Chinese Rose, Rose mallow, Chinese hibiscus, Hawaiian hibiscus, etc. Binomial name is Hibiscus rosa-sinensis and it belongs to the plant family Malvaceae. In our country Bangladesh this is known as Joba ful, Jhumka Joba, Joba Kushum, etc. This plant is native to East asian region. But now a days this is available in other tropical countries. This is an evergreen perennial shrubby plant. Leafs are semi ovate shaped with toothed at the border. I haven't seen any seed of this plant. Propagation is done using cutting. Flowers are having lot of colors starting from white, rose, yellow, red, orange, mixed, etc. This flower is being used as an example of perfect flower in the study of botany. By rubbing the Hibiscus petals over a white paper anyone could easily create litmus paper (which turns into red with acid and blue with base).\n" +
                        "\n" +
                        "Most of this flower having five petals, bracts, calyx, etc. Stamens are yellow and placed around the top of stigma. This flower doesn't have any redolence. People just love this for its color. In Malaysia, this flower is considered as their national flower. The state flower of Hawaii is Hibiscus flower (yellow one). In Hindu religion Hibiscus flower belongs to the Goddess Kali. \n" +
                        "In Bangladesh Hibiscus flower is known as Joba flower, Joba ful, Jhumka joba  etc.");
                image.setImageResource(R.drawable.joba);
                break;
            case "dumur":
                title.setText("Dumur");
                sub_title.setText("Ficus hispida");
                slide_description.setText("Dumur or Hairy fig (Ficus hispida, family: Moraceae) is a medium-sized tree from ficus genus with branches. The hairy-leaved tree is native to Bangladesh, as well as South and Southeast Asia and  New Guinea, Australia and Andaman island. Figs are eaten as vegetables in Bangladesh and India. Flowers remain inside fruit and cannot be seen from outside. Fruits called figs grow in cluster on branches. The ripe fruit is yellow. Ovulate green leaves are hairy and rough. Leaf is 12-18 cm long and pedicel is 2-5 cm long. Figs are used in stomach-ache and constipation. It is also used to cure different teeth diseases. Ripe fruits are eaten by birds and seeds are spread with their droppings. The plant grows in wilderness and fallow lands. It can be seen everywhere in Bangladesh. The species name 'hispida' derives from its hairy leaves.");
                image.setImageResource(R.drawable.dumur);
                break;


        }
    }

}