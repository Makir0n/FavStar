/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onestarfav;


import java.util.logging.Level;
import java.util.logging.Logger;
//import javafx.animation.Animation;
import twitter4j.Status;
//import twitter4j.StreamController;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.UserStreamAdapter;
//import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * void onFavorite(User source, User target, Status favoritedStatus)
 *
 * Parameters: source - source user of the event target - target user of the
 * event favoritedStatus - status favorited
 *
 * @author makiron
 */
public class GetFav {

    /**
     * @param args the command line arguments
     */
    static final String CONSUMER_KEY = "ePspaeeIwZsBmPE4jgzCH08UF";
    static final String CONSUMER_SECRET = "Buvna9kKXIB1p3OvUrpVD5SMinyP4v5StFUi6nXzkMjccahHIB";
    static final String ACCESS_TOKEN = "1445164536-aQHoQs0vigiKmDSq5JqZJqVRFrQOv7nFzMfOnkH";
    static final String ACCESS_TOKEN_SECRET = "zTpCNUNNlNGTyKWQxLDlJlcMkVXs2x6bMTaM0maUEzOkR";
    
    static public boolean FAV = false;
    
    public GetFav(){
        try {
            Fav();
        } catch (TwitterException ex) {
            Logger.getLogger(GetFav.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void Fav() throws TwitterException {

        Twitter twitter = new TwitterFactory().getInstance();

        MyUserStreamAdapter mMyUserStreamAdapter = new MyUserStreamAdapter();

        // Twitter4Jに対してOAuth情報を設定
        ConfigurationBuilder builder = new ConfigurationBuilder();

        {
            builder.setOAuthConsumerKey(CONSUMER_KEY);
            builder.setOAuthConsumerSecret(CONSUMER_SECRET);
            builder.setOAuthAccessToken(ACCESS_TOKEN);
            builder.setOAuthAccessTokenSecret(ACCESS_TOKEN_SECRET);
            builder.setUserStreamBaseURL("https://userstream.twitter.com/2/");
        }

        // 1. TwitterStreamFactory をインスタンス化する
        Configuration conf = builder.build();
        TwitterStreamFactory twitterStreamFactory = new TwitterStreamFactory(conf);
        // 2. TwitterStream をインスタンス化する
        TwitterStream twitterStream = twitterStreamFactory.getInstance();

    // ユーザーストリーム操作
        // 4. TwitterStream に UserStreamListener を実装したインスタンスを設定する
        twitterStream.addListener(mMyUserStreamAdapter);

        // 5. TwitterStream#user() を呼び出し、ユーザーストリームを開始する
        twitterStream.user();

    }

    static class MyUserStreamAdapter extends UserStreamAdapter {

        @Override
        public void onFavorite(User source, User target, Status favoritedStatus) {
            super.onFavorite(source, target, favoritedStatus);

            String message = source.getName() + "が" + target.getName() + "のツイート「" + favoritedStatus.getText() + "」をふぁぼった";

            System.out.println(message);
            
            FAV = true;
            //いつfalseにしよ
        }
    }
    public boolean isFav(){
        boolean fav = FAV;
        FAV = false;
        return fav;
    } 
}