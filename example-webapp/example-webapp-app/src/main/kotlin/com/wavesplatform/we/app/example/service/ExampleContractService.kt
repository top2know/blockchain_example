package com.wavesplatform.we.app.example.service

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
}
