package com.church.trust.thechurch.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.church.trust.thechurch.R;
import com.church.trust.thechurch.data.Weekly;
import com.church.trust.thechurch.edit.EditActivity;
import com.church.trust.thechurch.show.ShowActivity;
import com.church.trust.thechurch.util.ScreenSizeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.google.common.base.Preconditions.checkNotNull;
/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
// * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements MainContract.View {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    private MainContract.Presenter mPresenter;

//    private OnFragmentInteractionListener mListener;

    private GridAdapter mGridAdapter;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
//    public static MainFragment newInstance(String param1, String param2) {
//        MainFragment fragment = new MainFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
        mGridAdapter = new GridAdapter(new ArrayList<Weekly>(0), mItemListener, this.getContext());
    }

    @Override
    public void setPresenter(@NonNull MainContract.Presenter presenter) {
        mPresenter =  checkNotNull(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.main_frag, container, false);

        //set up main view
        GridView gridView = (GridView) root.findViewById(R.id.mainGridView);
        gridView.setAdapter(mGridAdapter);
        //set up floating action button
        FloatingActionButton fabAddWeekly = (FloatingActionButton) getActivity().findViewById(R.id.fab_add_weekly);
        fabAddWeekly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.addNewWeekly();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        return root;
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }

    WeeklyItemListener mItemListener = new WeeklyItemListener() {
        @Override
        public void onWeeklyClick(Weekly clickedWeekly) {
            mPresenter.openWeeklyDetails(clickedWeekly);
        }

        @Override
        public void onWeeklyClick_temp(int s) {
           mPresenter.openWeeklyDetails_temp(s);
        }
    };

    @Override
    public void showWeeklyDetailsUi(String weeklyId) {
        Intent intent = new Intent(getContext(), ShowActivity.class);
        intent.putExtra(ShowActivity.EXTRA_WEEKLY_ID, weeklyId);
        startActivity(intent);
    }

    @Override
    public void showAddWeekly() {
        Intent intent = new Intent(getContext(), EditActivity.class);
        startActivity(intent);
    }

    @Override
    public void showWeeklyDetailsUi_temp(int s) {
        Intent intent = new Intent(getContext(), ShowActivity.class);
        intent.putExtra(ShowActivity.EXTRA_temp_ID, s);
        startActivity(intent);
    }

    private class GridAdapter extends BaseAdapter{

        private List<Weekly> mWeeklyList;
        private WeeklyItemListener mItemListener;
        private Context mContext;

        public GridAdapter(List<Weekly> weeklyList, WeeklyItemListener itemListener, Context context) {
            setList(weeklyList);
            mItemListener = itemListener;
            mContext = context;
        }

        private void setList(List<Weekly> weeklyList){
            mWeeklyList = checkNotNull(weeklyList);
        }

        @Override
        public int getCount() {
            return 22;
//            return mWeeklyList.size();
        }

        @Override
        public Object getItem(int position) {
            return mWeeklyList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            DisplayMetrics metrics = ScreenSizeUtils.metrics(mContext);
            int actionbarSize = ScreenSizeUtils.actionbarSize(mContext);
            int statusbarSize = ScreenSizeUtils.statusbarSize(mContext);
            int tablayouSize = getResources().getDimensionPixelSize(R.dimen.tablayout_height);
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(metrics.widthPixels/3,(metrics.heightPixels-actionbarSize-statusbarSize-tablayouSize)/3));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            } else {
                imageView = (ImageView) convertView;
            }


           imageView.setImageResource(mThumbIds[position]);
            final int temp = mThumbIds[position];

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   mItemListener.onWeeklyClick_temp(temp);
                }
            });
//            final Weekly weekly = (Weekly) getItem(position);
//            int resID = getResources().getIdentifier(weekly.getId(),"drawable",getActivity().getPackageName());
//            imageView.setImageResource(resID);
//            imageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mItemListener.onWeeklyClick(weekly);
//                }
//            });
            return imageView;
        }
        private Integer[] mThumbIds = {
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7,
                R.drawable.sample_0, R.drawable.sample_1,
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7,
                R.drawable.sample_0, R.drawable.sample_1,
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7
        };

    }

    public interface WeeklyItemListener{

        void onWeeklyClick(Weekly clickedWeekly);
        void onWeeklyClick_temp(int s);

    }

}
