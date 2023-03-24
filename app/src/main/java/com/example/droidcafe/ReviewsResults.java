package com.example.droidcafe;

import java.util.List;

public class ReviewsResults {

    /**
     * id : 804150
     * page : 1
     * results : [{"author":"MSB","author_details":{"name":"MSB","username":"msbreviews","avatar_path":"/https://www.gravatar.com/avatar/992eef352126a53d7e141bf9e8707576.jpg","rating":6},"content":"FULL SPOILER-FREE REVIEW @ https://www.msbreviews.com/movie-reviews/cocaine-bear-review\r\n\r\n\"COCAINE BEAR offers what one expects from it: an absolutely INSANE bear wreaking gory, bloody havoc while also doing the stupidest things imaginable. A totally nonsensical yet extremely entertaining time where nothing else matters besides the bear who did cocaine.\"\r\n\r\nRating: B-","created_at":"2023-02-23T21:14:37.835Z","id":"63f7d73d68b1ea0079cc0a45","updated_at":"2023-02-23T21:14:37.955Z","url":"https://www.themoviedb.org/review/63f7d73d68b1ea0079cc0a45"},{"author":"CinemaSerf","author_details":{"name":"CinemaSerf","username":"Geronimo1967","avatar_path":"/1kks3YnVkpyQxzw36CObFPvhL5f.jpg","rating":7},"content":"OK, so the plot wears a little thin after a while but I really did quite enjoy this daft action adventure film. It all starts with a bloke tossing bags from an aircraft before he clonks his head on the door whilst leaving, mid-air, and next thing the police are identifying the body and a large duffle bag of cocaine. Where's the rest of it? Well out near the original \"glory hole\" at Cagney's Cavern a bear is having the time of her life - and snacking on just about anything that crosses her path - including Scandi tourists as an appetiser! A couple of kids \"Dee Dee\" (Brooklyn Prince) and \"Henry\" (Christian Convery) bunk off school to visit a waterfall and pretty soon her mother and the feisty park ranger \"Liz\" (Margo Martindale) are all trying to find them and stay one step ahead of the increasingly stoned apex predator. It's got funny moments, scary moments - downright silly moments; Martindale and the young Convery are good fun too, and there is even a bit of a moral to the story from \"Eddie\" (Alden Ehrenreich) who is determined to opt out of the drug dealing business of his ruthless dad \"Syd\" (Ray Liotta). It's not often folks laugh out loud in a cinema these days and folks did - as did I - tonight. Rocket science it isn't, but entertaining it certainly is and the bear has some nifty moves, too!","created_at":"2023-02-26T23:13:53.693Z","id":"63fbe7b157176f007cfd8ce4","updated_at":"2023-02-26T23:13:53.807Z","url":"https://www.themoviedb.org/review/63fbe7b157176f007cfd8ce4"},{"author":"Nathan","author_details":{"name":"Nathan","username":"TitanGusang","avatar_path":"/yHGV91jVzmqpFOtRSHF0avBZmPm.jpg","rating":5},"content":"After the initial hit of Cocaine Bear, the film left me scratching for something a little stronger.\r\n\r\nI think the main drawback of this film is that it is trying to do too much. There are seven to eight characters introduced throughout the course of the film, with each given significant time to develop their story and motivations. This takes a lot of time away from the main attraction, the cocaine bear. There is a period of almost 45 minutes where we are focused on these \"secondary\" characters, without any action or appearance of the cocaine bear. This section was pretty slow paced and started to lose me, but once the bear is re-introduced, the film gets significantly better. The paramedic scene was superb.\r\n\r\nThe comedy was pretty lackluster as well. The entire theater was laughing aloud, but I found myself only chuckling at a few jokes. This left the script feeling somewhat bland. But the lack of humor is made up for by the absolute brutality on display. There are some really messed up kills that do not shy away from the blood and gore. Some of the effects looked to be prosthetics as well, which always have an especially disgusting appearance to them.\r\n\r\nThe story overall was pretty decent, but the ending was atrocious and incredibly predictable. I found that it was really over the top and cheesy, but not in a good way. \r\n\r\nThe visual appearance of the bear was pretty solid. The CGI was done well but is spotty in a couple of scenes. Overall, I was slightly entertained by this film, but I can't help but feel it did not live up to its full potential.\r\n\r\nScore: 55% |\r\nVerdict: Average","created_at":"2023-03-03T14:47:50.911Z","id":"64020896c7176d009d6f855c","updated_at":"2023-03-03T14:47:50.991Z","url":"https://www.themoviedb.org/review/64020896c7176d009d6f855c"},{"author":"mooney240","author_details":{"name":"","username":"mooney240","avatar_path":"/blEC280vq31MVaDcsWBXuGOsYnB.jpg","rating":6},"content":"**Cocaine Bear delivers ridiculous creature violence on some goofy, short-lived characters, but its lack of consistent tone and identity kept it from being everything I had hoped.**\r\n\r\nLet\u2019s start with this: I am a massive fan of lane creature movies - Ghost Shark, Sharknado, Lavalantula, The Sand - some of my favorites. So I expected to love Cocaine Bear. Sadly, I was a little underwhelmed. It wasn\u2019t bad for what it was, but it didn\u2019t dazzle me as I had hoped. Two things held it back for me:\r\n\r\n1. The tone inconsistently switched from a Zombieland-style ridiculous violence to a goofy crime movie to an odd family drama. Cocaine Bear had a minor identity crisis from start to finish.\r\n\r\n2. The movie tried to give each character a little backstory and development. While this is generally a good thing, in a low-budget creature movie, it slows down the nonsensical violence that the audience came for in the first place. Spend time on one or two characters but not all of them. I didn\u2019t need to know about the drug lord\u2019s grandson or the detective\u2019s dog. I just need to see more people get eaten 😆.\r\n\r\nI appreciated the larger-budget kills and the oddball characters. If it continues, I will come back for a second try in this franchise, but ultimately I wasn\u2019t high on Cocaine Bear (get it? 😜).","created_at":"2023-03-16T20:28:13.170Z","id":"64137bdd323eba00ef641969","updated_at":"2023-03-16T20:28:13.298Z","url":"https://www.themoviedb.org/review/64137bdd323eba00ef641969"}]
     * total_pages : 1
     * total_results : 4
     */

    private int id;
    private int page;
    private int total_pages;
    private int total_results;
    private List<ResultsBean> results;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * author : MSB
         * author_details : {"name":"MSB","username":"msbreviews","avatar_path":"/https://www.gravatar.com/avatar/992eef352126a53d7e141bf9e8707576.jpg","rating":6}
         * content : FULL SPOILER-FREE REVIEW @ https://www.msbreviews.com/movie-reviews/cocaine-bear-review
         * <p>
         * "COCAINE BEAR offers what one expects from it: an absolutely INSANE bear wreaking gory, bloody havoc while also doing the stupidest things imaginable. A totally nonsensical yet extremely entertaining time where nothing else matters besides the bear who did cocaine."
         * <p>
         * Rating: B-
         * created_at : 2023-02-23T21:14:37.835Z
         * id : 63f7d73d68b1ea0079cc0a45
         * updated_at : 2023-02-23T21:14:37.955Z
         * url : https://www.themoviedb.org/review/63f7d73d68b1ea0079cc0a45
         */

        private String author;
        private AuthorDetailsBean author_details;
        private String content;
        private String created_at;
        private String id;
        private String updated_at;
        private String url;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public AuthorDetailsBean getAuthor_details() {
            return author_details;
        }

        public void setAuthor_details(AuthorDetailsBean author_details) {
            this.author_details = author_details;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public static class AuthorDetailsBean {
            /**
             * name : MSB
             * username : msbreviews
             * avatar_path : /https://www.gravatar.com/avatar/992eef352126a53d7e141bf9e8707576.jpg
             * rating : 6.0
             */

            private String name;
            private String username;
            private String avatar_path;
            private double rating;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getAvatar_path() {
                return avatar_path;
            }

            public void setAvatar_path(String avatar_path) {
                this.avatar_path = avatar_path;
            }

            public double getRating() {
                return rating;
            }

            public void setRating(double rating) {
                this.rating = rating;
            }
        }
    }
}
