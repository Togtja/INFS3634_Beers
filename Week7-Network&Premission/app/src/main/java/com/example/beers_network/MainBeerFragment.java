package com.example.beers_network;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.beers_network.RecyclerView.BeersAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class MainBeerFragment extends Fragment implements BeersFragment.OnFragmentInteractionListener{

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    //private List<Beer> beers = new ArrayList<>();
   //t beersFragment;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MainBeerFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MainBeerFragment newInstance(int columnCount) {
        MainBeerFragment fragment = new MainBeerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }


/*
        beersFragment = new BeersFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.ViewBeerFragment, beersFragment).commit();
*/
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        //View t_view = inflater.inflate(R.layout.fragment_mainbeer_list, container, false);

        View view = inflater.inflate(R.layout.fragment_mainbeer_list, container, false);


        RecyclerView rV = view.findViewById(R.id.BeerRV);

        rV.setLayoutManager(new LinearLayoutManager(getActivity()));


        final List<Beer> beers = (ArrayList<Beer>) getArguments().getSerializable("key_beer");
        BeersAdapter mAdapter = new BeersAdapter(beers);


        rV.setAdapter(mAdapter);

        rV.setHasFixedSize(true);
        Context context = getContext();
        final Bundle bundle = new Bundle();
        rV.addOnItemTouchListener(
                new RecyclerItemClickListener(context, rV, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        BeersFragment beersFragment = new BeersFragment();
                        Beer theBeer = beers.get(position);
                        bundle.putSerializable("Beer", theBeer);
                        beersFragment.setArguments(bundle);
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        View parentView = inflater.inflate(R.layout.activity_main, container, false);
                        if(parentView.findViewById(R.id.ViewBeerFragment) == null){

                            transaction.replace(R.id.ListFragment, beersFragment)
                                    .addToBackStack(null).commit();
//                              FrameLayout t = view.findViewById(R.id.ListFragment);
//                            t.setBackgroundColor(Color.rgb(255,214,214));
                        }
                        else{
                            transaction.replace(R.id.ViewBeerFragment, beersFragment)
                                    .addToBackStack(null).commit();
                        }



                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                    }
                })
        );




        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void onItemClick(int position){
        mListener.onListFragmentInteraction(position);
    }

    public void OnListFragmentInteractionListener(MainActivity activity){
        mListener = activity;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(int position);
    }

}
