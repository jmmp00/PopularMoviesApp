package com.example.droidcafe;

import java.util.List;

public class TrailerResults {
    /**
     * id : 804150
     * results : [{"iso_639_1":"en","iso_3166_1":"US","name":"WHITE LINES (Cocaine Bear Remix) by Pusha T (Official Lyric Video)","key":"HPuAiuyJX0g","site":"YouTube","size":1080,"type":"Featurette","official":true,"published_at":"2023-02-24T01:36:19.000Z","id":"63f9606457176f00db7ed5c7"},{"iso_639_1":"en","iso_3166_1":"US","name":"Cocaine Bear Exclusive Featurette - An Inside Look (2023)","key":"ojOCsWqtUOY","site":"YouTube","size":1080,"type":"Behind the Scenes","official":false,"published_at":"2023-01-31T16:00:34.000Z","id":"63d95ac3a6c104007f632e20"},{"iso_639_1":"en","iso_3166_1":"US","name":"Official Trailer","key":"DuWEEKeJLMI","site":"YouTube","size":1080,"type":"Trailer","official":true,"published_at":"2022-11-30T17:59:16.000Z","id":"63879e631b157d00c9fa50e2"}]
     */

    private int id;
    private List<ResultsBean> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * iso_639_1 : en
         * iso_3166_1 : US
         * name : WHITE LINES (Cocaine Bear Remix) by Pusha T (Official Lyric Video)
         * key : HPuAiuyJX0g
         * site : YouTube
         * size : 1080
         * type : Featurette
         * official : true
         * published_at : 2023-02-24T01:36:19.000Z
         * id : 63f9606457176f00db7ed5c7
         */

        private String key;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }
}
