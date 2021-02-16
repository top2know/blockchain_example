package com.wavesplatform.we.app.example.contract

import com.wavesplatform.vst.contract.ContractAction
import com.wavesplatform.vst.contract.ContractInit

interface ExampleContract {

    @ContractInit
    fun create()

    @ContractAction
    fun invoke()
}
