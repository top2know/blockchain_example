package com.wavesplatform.we.app.example.app.api

data class CreatePersonRequest(
        val num: String,
        val name: String
)

data class CreateDoctorRequest(
        val num: String,
        val name: String,
        val level: String
)

data class SetRecordRequest(
        val record_num: String,
        val doctor_num: String,
        val person_num: String,
        val content: String,
        val level: String
)

data class GetRecordRequest(
        val record_num: String,
        val doctor_num: String,
        val person_num: String
)

data class GetRecordsRequest(
        val doctor_num: String,
        val person_num: String
)