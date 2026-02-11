package capital.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import capital.data.local.convert.CountryTypeConverters
import capital.data.local.dao.CountryDao
import capital.data.local.entity.CountryEntity

@Database(entities = [CountryEntity::class], version = 1, exportSchema = true)
@TypeConverters(CountryTypeConverters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun countryDao(): CountryDao
}