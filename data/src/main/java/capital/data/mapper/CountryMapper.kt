package capital.data.mapper

import capital.data.local.entity.CountryEntity
import capital.data.model.CountryResponse
import capital.domain.model.Capital
import capital.domain.model.Country

fun CountryResponse.toEntity(): CountryEntity {
    return CountryEntity(
        countryCode = this.countryCode,
        continent = this.continent,
        countryKo = this.countryKo,
        countryEn = this.countryEn,
        capitals = this.capitals, // TypeConverter가 처리
        languages = this.languages // TypeConverter가 처리
    )
}

fun CountryEntity.toDomain(): Country {
    return Country(
        code = this.countryCode,
        nameKo = this.countryKo,
        nameEn = this.countryEn,
        continent = this.continent,
        capitals = this.capitals.map { it -> Capital( koreaName = it.ko, engName = it.en) },
        languages = this.languages
    )
}