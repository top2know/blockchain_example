package com.wavesplatform.we.app.example.contract

import com.wavesplatform.vst.contract.ContractAction
import com.wavesplatform.vst.contract.ContractInit
import com.wavesplatform.vst.contract.InvokeParam

interface ExampleContract {

    @ContractInit
    fun create()

    @ContractAction
    fun invoke()

    @ContractAction
    fun createPerson(
            @InvokeParam(name="num") num: String,
            @InvokeParam(name="name") name: String
    )

    @ContractAction
    fun createDoctor(
            @InvokeParam(name="num") num: String,
            @InvokeParam(name="name") name: String,
            @InvokeParam(name="level") level: String
    )

    @ContractAction
    fun setRecord(
            @InvokeParam(name="record_num") record_num: String,
            @InvokeParam(name="person_num") person_num: String,
            @InvokeParam(name="doctor_num") doctor_num: String,
            @InvokeParam(name="content") content: String,
            @InvokeParam(name="level") level: String
    )

    @ContractAction
    fun getRecord(
            @InvokeParam(name="person_num") person_num: String,
            @InvokeParam(name="doctor_num") doctor_num: String,
            @InvokeParam(name="record_num") record_num: String
    )

    @ContractAction
    fun getRecords(
            @InvokeParam(name="person_num") person_num: String,
            @InvokeParam(name="doctor_num") doctor_num: String
    )
}
