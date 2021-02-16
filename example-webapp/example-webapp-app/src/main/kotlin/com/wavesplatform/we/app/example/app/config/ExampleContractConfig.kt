package com.wavesplatform.we.app.example.app.config

import com.wavesplatform.we.app.example.contract.ExampleContract
import com.wavesplatform.we.app.example.contract.impl.ExampleContractImpl
import com.wavesplatform.we.starter.contract.annotation.Contract
import com.wavesplatform.we.starter.contract.annotation.EnableContracts
import org.springframework.context.annotation.Configuration

@Configuration
@EnableContracts(
        contracts = [Contract(
                api = ExampleContract::class,
                impl = ExampleContractImpl::class,
                name = "example"
        )]
)
class ExampleContractConfig