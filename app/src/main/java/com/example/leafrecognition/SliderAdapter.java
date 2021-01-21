package com.example.leafrecognition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import de.hdodenhof.circleimageview.CircleImageView;


public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }
    //Array
    public int[] sliderImage= new int[]{
            R.drawable.pata1,
            R.drawable.pata2,
            R.drawable.pata3
    };
    public String[] headings={
      "Find","Capture","Details"
    };

    public String[] discription= {
      "The degree of a vertex in a graph is the number of edges incident to it. An isolated vertex is a vertex with degree zero; that is, a vertex that is not an endpoint of any edge. A leaf vertex (also pendant vertex) is a vertex with degree one.",
      "The degree of a vertex in a graph is the number of edges incident to it. An isolated vertex is a vertex with degree zero; that is, a vertex that is not an endpoint of any edge. A leaf vertex (also pendant vertex) is a vertex with degree one.",
      "The degree of a vertex in a graph is the number of edges incident to it. An isolated vertex is a vertex with degree zero; that is, a vertex that is not an endpoint of any edge. A leaf vertex (also pendant vertex) is a vertex with degree one."
    };

    @Override
    public int getCount() {
        return headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);
        CircleImageView slideImageView=(CircleImageView) view.findViewById(R.id.slide_img);
        TextView slideHeading=(TextView)view.findViewById(R.id.slide_heading);
        TextView slideDescription=(TextView)view.findViewById(R.id.slide_description);
        slideImageView.setImageResource(sliderImage[position]);
        slideHeading.setText(headings[position]);
        slideDescription.setText(discription[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
