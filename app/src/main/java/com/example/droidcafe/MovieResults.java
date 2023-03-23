package com.example.droidcafe;

import java.io.Serializable;
import java.util.List;

public class MovieResults {


    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    public static class ResultsBean implements Serializable {
        /**
         * adult : false
         * backdrop_path : /2Eewgp7o5AU1xCataDmiIL2nYxd.jpg
         * genre_ids : [18,36]
         * id : 943822
         * original_language : en
         * original_title : Prizefighter: The Life of Jem Belcher
         * overview : At the turn of the 19th century, Pugilism was the sport of kings and a gifted young boxer fought his way to becoming champion of England.
         * popularity : 2682.314
         * poster_path : /x3PIk93PTbxT88ohfeb26L1VpZw.jpg
         * release_date : 2022-06-30
         * title : Prizefighter: The Life of Jem Belcher
         * video : false
         * vote_average : 7.2
         * vote_count : 57
         */

        private int id;
        private String overview;
        private String poster_path;
        private String release_date;
        private String title;
        private double vote_average;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOverview() {
            return overview;
        }

        public String getPoster_path() {
            return poster_path;
        }

        public String getRelease_date() {
            return release_date;
        }

        public String getTitle() {
            return title;
        }

        public double getVote_average() {
            return vote_average;
        }

    }
}
