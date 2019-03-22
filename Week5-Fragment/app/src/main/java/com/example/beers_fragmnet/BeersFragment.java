package com.example.beers_fragmnet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.beers_fragmnet.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BeersFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BeersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeersFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private String message;

    private  Beer theBeer;

    public BeersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BeersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BeersFragment newInstance(String param1, String param2) {
        BeersFragment fragment = new BeersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Bundle bundle = getArguments();
        if(bundle != null){
            message = bundle.getString("DETAIL");
        }
        */



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mainbeer, container, false);

        Bundle bundle = getArguments();

        if(bundle != null){
            //view.setVisibility(View.VISIBLE);

            theBeer = (Beer) bundle.getSerializable("Beer");
            Log.d( "Click", "We click on" + theBeer.getName());
            //The Beer name
            TextView beerName = view.findViewById(R.id.BeerName);
            beerName.setText(theBeer.getName());
            //The beer short desc
            TextView beerShortDesc = view.findViewById(R.id.BeerShortDesc);
            beerShortDesc.setText(theBeer.getShortDescription());
            //The beer description
            TextView beerDesc = view.findViewById(R.id.BeerDesc);
            beerDesc.setText(theBeer.getDescription() + '\n');
            //The ABV nr
            TextView ABVnr = view.findViewById(R.id.ABV_Nr);
            ABVnr.setText(Double.toString(theBeer.getAbv())+"%");
            //The IBU
            TextView ibu = view.findViewById(R.id.BeerIBU);
            ibu.setText("IBU: " + theBeer.getIbuMin() + " - " + theBeer.getIbuMax());
            //The SRM (I know I spelled it SMR but don't bother to fix it now)
            TextView smr = view.findViewById(R.id.BeerSMR);
            smr.setText("SRM: " + theBeer.getSrmMin() + " - " + theBeer.getSrmMax());
            //The brand name
            TextView brandName = view.findViewById(R.id.BrandName);
            brandName.setText(theBeer.getBrewery());

        }
        else{
            Log.d("NULL", "Empty bundle for a beer");
        }


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    /*
    public void onButtonPressed(int position) {
        if (mListener != null) {
            mListener.onFragmentInteraction(position);
        }
    }*/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        */
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

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
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        //void onFragmentInteraction(int position);
        // Currently no interactions needed
    }
    public void OnFragmentInteractionListener(MainActivity activity) {
        //mListener = activity;
    }
}
