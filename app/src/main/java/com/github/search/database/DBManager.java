package com.github.search.database;

import com.github.search.Utilities;

import org.json.JSONArray;
import org.json.JSONException;
import java.io.IOException;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;
import okhttp3.ResponseBody;

/**
 * Created by yellappa on 18/1/18.
 */

public class DBManager {
    private static DBManager dbManager = null;
    private Realm realm;
    private DBManager(){
        realm = Realm.getDefaultInstance();
    }

    public static DBManager getInstance(){
        if (dbManager == null){
            dbManager = new DBManager();
        }
        return  dbManager;
    }

    public void createRepos(ResponseBody responseBody){
        try {
            String jsonStr = responseBody.string();
            realm.beginTransaction();
            RepoResultsEntity repoResultsEntity = realm.where(RepoResultsEntity.class).findFirst();

            if (repoResultsEntity != null && repoResultsEntity.isValid()){
                repoResultsEntity.deleteFromRealm();
            }
            RepoResultsEntity repoResult = realm.createOrUpdateObjectFromJson(RepoResultsEntity.class, jsonStr);
            for (RepositoryEntity repositoryEntity: repoResult.items){
                Date date = Utilities.stringToDate(repositoryEntity.created_at);
                repositoryEntity.createdAt = date;
            }
            realm.commitTransaction();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createContributorsFromJsonResponse(ResponseBody responseBody, int repoId){
        try {
            String jsonString = responseBody.string();
            JSONArray jsonArray = new JSONArray(jsonString);
            realm.beginTransaction();
            realm.createOrUpdateAllFromJson(ContributorEntity.class, jsonArray);

            for (ContributorEntity contributorEntity: realm.where(ContributorEntity.class).equalTo("parentRepoId", -1).findAll()){
                contributorEntity.parentRepoId = repoId;
            }
            realm.commitTransaction();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void createReposFromJsonResponse(ResponseBody responseBody){
        try {
            String jsonString = responseBody.string();
            JSONArray jsonArray = new JSONArray(jsonString);
            realm.beginTransaction();
            realm.createOrUpdateAllFromJson(RepositoryEntity.class, jsonArray);
            realm.commitTransaction();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
