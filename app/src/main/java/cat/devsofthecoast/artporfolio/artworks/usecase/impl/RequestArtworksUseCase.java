package cat.devsofthecoast.artporfolio.artworks.usecase.impl;
import android.util.Log;

import cat.devsofthecoast.artporfolio.bases.appconfig.AppConfig;
import cat.devsofthecoast.artporfolio.bases.usecases.Callback;
import cat.devsofthecoast.artporfolio.bases.usecases.UseCase;
import cat.devsofthecoast.artporfolio.bases.usecases.UseCaseCallback;
import cat.devsofthecoast.artporfolio.bases.usecases.UseCaseExecutor;
import cat.devsofthecoast.artporfolio.utils.StringUtils;

public class RequestArtworksUseCase implements UseCase<String, String> {

    private final AppConfig appConfig;
    private final StringUtils repository;

    public RequestArtworksUseCase(AppConfig appConfig, StringUtils stringUtils) {
        this.appConfig = appConfig;
        this.repository = stringUtils;
    }

    @Override
    public void run(String input, Callback<String> callback) {
        Log.d("UseCase", "Thread name: " + Thread.currentThread().getName() + " \n Thread ID: " + Thread.currentThread().getId());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            callback.onError(e);
        }
        callback.onSuccess("Succes Shitty Usecase " + input + " \n from Repo get this: " + repository.insultMe() + "\n" + "THREAD NAME: " + Thread.currentThread().getName());
    }

    @Override
    public UseCaseExecutor<String, String> buildExecutor(UseCaseCallback<String> useCaseCallback) {
        return new Executor(useCaseCallback);
    }

    private class Executor extends UseCaseExecutor<String, String> {
        private Executor(UseCaseCallback<String> useCaseCallback) {
            super(appConfig, RequestArtworksUseCase.this, useCaseCallback);
        }
    }
}
