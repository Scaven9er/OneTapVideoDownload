package com.phantom.onetapvideodownload;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DownloadsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private DownloadAdapter mDownloadAdapter;

    public DownloadsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = inflater.inflate(R.layout.fragment_downloads, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.downloadRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);

        mDownloadAdapter = new DownloadAdapter(getActivity());
        mRecyclerView.setAdapter(mDownloadAdapter);

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mDownloadAdapter != null) {
            mDownloadAdapter.onStop();
        }
    }
}
