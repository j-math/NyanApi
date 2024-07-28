package com.jma.nyanapi.di

import android.app.Application
import android.content.Context
import com.jma.nyanapi.util.SharedPreferenceNyanApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

//    @Provides
//    @DispatcherIo
//    fun providesDispatcherIo() = Dispatchers.IO
//
//    @Provides
//    @DispatcherMain
//    fun providesDispatcherMain() = Dispatchers.Main

//    @Provides
//    @ApplicationScope
//    fun providesApplicationScope() = MainScope()

    @Provides
    fun providesSharedPreference(@ApplicationContext context: Context) =
        SharedPreferenceNyanApi(context)


}