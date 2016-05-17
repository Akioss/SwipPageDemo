package com.akioss.swippagedemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SwipeFragment extends Fragment {

    private static final String ARG_TITLE = "title";

    private String title;
    private View rootView;
    private LinearLayout mLinearLayout;
    private ImageView showImage;
    private TextView showTitleTextView;
    private TextView showDescTextView;
    private TextView showPriceTextView;
    private View lineView;
    private Button showBuyButton;

    public SwipeFragment() {
        // Required empty public constructor
    }

    public static SwipeFragment newInstance(String title) {
        SwipeFragment fragment = new SwipeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.item_viewpager_card, container, false);
        mLinearLayout = (LinearLayout) rootView.findViewById(R.id.big_layout);
        showImage = (ImageView) rootView.findViewById(R.id.show_iv);
        showTitleTextView = (TextView) rootView.findViewById(R.id.title_tv);
        showDescTextView = (TextView) rootView.findViewById(R.id.desc_tv);
        showPriceTextView = (TextView) rootView.findViewById(R.id.show_price_tv);
        lineView = rootView.findViewById(R.id.line_view);
        showBuyButton = (Button) rootView.findViewById(R.id.show_buy_btn);

        mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pair<View, String> imagePair = new Pair<View, String>(showImage, "show_image");
                Pair<View, String> layoutPair = new Pair<View, String>(mLinearLayout, "big_layout");
                Pair<View, String> titlePair = new Pair<View, String>(showTitleTextView, "show_title");
                Pair<View, String> descPair = new Pair<View, String>(showDescTextView, "show_desc");
                Pair<View, String> pricePair = new Pair<View, String>(showPriceTextView, "show_price");
                Pair<View, String> linePair = new Pair<>(lineView, "show_line");
                Pair<View, String> buyPair = new Pair<View, String>(showBuyButton, "show_buy");
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                        getActivity(),
                        imagePair,
                        layoutPair,
                        titlePair,
                        descPair,
                        pricePair,
                        linePair,
                        buyPair
                );
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                ActivityCompat.startActivity(getActivity(), intent, options.toBundle());
            }
        });

        return rootView;
    }

}
