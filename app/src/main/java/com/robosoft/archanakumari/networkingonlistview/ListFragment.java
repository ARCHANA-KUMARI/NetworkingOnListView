package com.robosoft.archanakumari.networkingonlistview;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.robosoft.archanakumari.networkingonlistview.adapter.RecyclerViewAdapter;
import com.robosoft.archanakumari.networkingonlistview.dto.ListWrapper;
import com.robosoft.archanakumari.networkingonlistview.manager.DownloadManager;
import com.robosoft.archanakumari.networkingonlistview.network.VolleyHelper;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    private ListView mListview;
    private RecyclerView mRecyclerView;
    private String mUrl;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private LinearLayoutManager mLayoutManager;

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
      //  mListview = (ListView) view.findViewById(R.id.list_view);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        return  view;
    }
    @Override

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        downoadData();

    }

    private void downoadData() {

       // mUrl = "http://demo.codeofaninja.com/tutorials/json­example­with­php/index.php";
         mUrl = "http://api.learn2crack.com/android/jsonos/";


        DownloadManager.downloadData(getActivity(), mUrl, new Response.Listener<ListWrapper>() {

            @Override

            public void onResponse(ListWrapper response) {

                if (getActivity() == null)

                    return;

               // mListview.setAdapter(new ListAdapter(getActivity(), response.userList));
                mRecyclerViewAdapter = new RecyclerViewAdapter(getActivity(),response.userList);

                mRecyclerView.setAdapter(mRecyclerViewAdapter);

            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if (getActivity() == null)

                    return;
            }



        });
    }
    @Override

    public void onDetach() {

        super.onDetach();

        VolleyHelper.getInstance(getActivity()).cancelRequest(mUrl);
    }
}
