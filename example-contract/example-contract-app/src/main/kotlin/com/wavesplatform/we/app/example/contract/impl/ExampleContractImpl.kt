package com.wavesplatform.we.app.example.contract.impl

import com.wavesplatform.vst.contract.data.ContractCall
import com.wavesplatform.vst.contract.mapping.Mapping
import com.wavesplatform.vst.contract.spring.annotation.ContractHandlerBean
import com.wavesplatform.vst.contract.state.ContractState
import com.wavesplatform.vst.contract.state.setValue
import com.wavesplatform.vst.contract.state.getValue
import com.wavesplatform.we.app.example.contract.ExampleContract

@ContractHandlerBean
class ExampleContractImpl(
    state: ContractState,
    private val call: ContractCall
) : ExampleContract {

    private var create: Boolean? by state
    private var invoke: Boolean? by state

    private val persons: Mapping<Person> by state
    private val doctors: Mapping<Doctor> by state

    override fun create() {
        create = true
    }

    override fun invoke() {
        invoke = true
    }

    override fun createPerson(num: String, name: String) {
        require(!persons.has(num)) {
            "PERSON_ALREADY_EXISTS"
        }

        var person = Person(num=num, name=name)
        persons.put(num, person)
    }

    override fun createDoctor(num: String, name: String, level: String) {
        require(!doctors.has(num)) {
            "DOCTOR_ALREADY_EXISTS"
        }

        var doctor = Doctor(num=num, name=name, level=level)
        doctors.put(num, doctor)
    }

    override fun setRecord(record_num: String, person_num: String, doctor_num: String, content: String, level: String) {

        require(persons.has(person_num)) {
            "PERSON_NOT_EXISTS"
        }
        require(!persons[person_num].records.containsKey(record_num)) {
            "RECORD_ALREADY_EXISTS"
        }
        require(doctors.has(doctor_num)) {
            "DOCTOR_NOT_EXISTS"
        }

        var record = Record(
                num = record_num,
                doctor_num = doctor_num,
                content = content,
                level = level
        )

        persons[person_num].records.put(record_num, record)
    }

    override fun getRecord(person_num: String, doctor_num: String, record_num: String) {
        require(persons.has(person_num)) {
            "PERSON_NOT_EXISTS"
        }
        require(doctors.has(doctor_num)) {
            "DOCTOR_NOT_EXISTS"
        }
        require(persons[person_num].records.containsKey(record_num)) {
            "RECORD_NOT_EXISTS"
        }
        require(doctors[doctor_num].level >= persons[person_num].records[record_num]!!.level) {
            "ACCESS_DENIED"
        }

        doctors[doctor_num].gotten_records.add(persons[person_num].records[record_num]!!)
    }

    override fun getRecords(person_num: String, doctor_num: String) {
        require(persons.has(person_num)) {
            "PERSON_NOT_EXISTS"
        }
        require(doctors.has(doctor_num)) {
            "DOCTOR_NOT_EXISTS"
        }
        for (record_num in persons[person_num].records.keys)
            if (doctors[doctor_num].level >= persons[person_num].records[record_num]!!.level)
                doctors[doctor_num].gotten_records.add(persons[person_num].records[record_num]!!)
    }
}

class Person (
        var num: String,
        var name: String,
        var records: HashMap<String, Record> = HashMap()
        )

data class Doctor (
        var num: String,
        var name: String,
        var level: String,
        var gotten_records: ArrayList<Record> = ArrayList()
        )

data class Record (
        var num: String,
        var doctor_num: String,
        var content: String,
        var level: String
        )
