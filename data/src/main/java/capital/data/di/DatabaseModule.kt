package capital.data.di

import android.content.Context
import androidx.room.Room
import capital.data.local.dao.CountryDao
import capital.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            klass = AppDatabase::class.java,
            name = "capital.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideCountryDao(database: AppDatabase): CountryDao {
        return database.countryDao()
    }
}