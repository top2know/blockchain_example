package com.wavesplatform.we.app.example.app.service

import com.wavesplatform.vst.contract.factory.ContractClientFactory
import com.wavesplatform.we.app.example.contract.ExampleContract
import org.springframework.stereotype.Service

@Service
class ExampleContractService(
    val factory: ContractClientFactory<ExampleContract>
) {
        fun create(): String {
                val api = factory.client { it.contractName("example") }
                api.contract().create()
                return api.lastTxId
        }

        fun invoke(id: String): String {
                val api = factory.client { it.contractId(id) }
                api.contract().invoke()
                return api.lastTxId
        }

        fun createDoctor(
                contractId: String,
                num: String,
                name: String,
                level: String
        ): String {
                val api = factory.client { it.contractId(contractId) }
                api.contract().createDoctor(num, name, level)
                return api.lastTxId
        }

        fun createPerson(
                contractId: String,
                num: String,
                name: String
        ): String {
                val api = factory.client { it.contractId(contractId) }
                api.contract().createPerson(num, name)
                return api.lastTxId
        }

        fun setRecord(
                contractId: String,
                record_num: String,
                doctor_num: String,
                person_num: String,
                content: String,
                level: String
        ): String {
                val api = factory.client { it.contractId(contractId) }
                api.contract().setRecord(
                        record_num=record_num,
                        person_num=person_num,
                        doctor_num=doctor_num,
                        content=content,
                        level=level)
                return api.lastTxId
        }

        fun getRecord(
                contractId: String,
                record_num: String,
                doctor_num: String,
                person_num: String
        ): String {
                val api = factory.client { it.contractId(contractId) }
                api.contract().getRecord(
                        record_num=record_num,
                        person_num=person_num,
                        doctor_num=doctor_num)
                return api.lastTxId
        }

        fun getRecords(
                contractId: String,
                doctor_num: String,
                person_num: String
        ): String {
                val api = factory.client { it.contractId(contractId) }
                api.contract().getRecords(
                        person_num=person_num,
                        doctor_num=doctor_num)
                return api.lastTxId
        }
}
