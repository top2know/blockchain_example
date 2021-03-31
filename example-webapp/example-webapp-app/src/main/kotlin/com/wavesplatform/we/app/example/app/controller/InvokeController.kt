package com.wavesplatform.we.app.example.app.controller

import com.wavesplatform.we.app.example.app.api.*
import com.wavesplatform.we.app.example.app.service.ExampleContractService
import org.springframework.http.HttpStatus.ACCEPTED
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("public/create_person")
class CreatePersonController(
        val contractService: ExampleContractService
) {

    @PostMapping
    fun create(
            @RequestBody rq: CreatePersonRequest
    ): ResponseEntity<TxDto> {
        val id = contractService.createPerson(
                contractId = "5h3ma4vxZ73hrCcTqC9rbHnotmX3TsgusUsp4GUD1HuA",
                num = rq.num,
                name = rq.name
        )
        return ResponseEntity(TxDto(id), ACCEPTED)
    }
}

@RestController
@RequestMapping("public/create_doctor")
class CreateDoctorController(
        val contractService: ExampleContractService
) {

    @PostMapping
    fun create(
            @RequestBody rq: CreateDoctorRequest
    ): ResponseEntity<TxDto> {
        val id = contractService.createDoctor(
                contractId = "5h3ma4vxZ73hrCcTqC9rbHnotmX3TsgusUsp4GUD1HuA",
                num = rq.num,
                name = rq.name,
                level =  rq.level
        )
        return ResponseEntity(TxDto(id), ACCEPTED)
    }
}


@RestController
@RequestMapping("public/set_record")
class SetRecordController(
        val contractService: ExampleContractService
) {

    @PostMapping
    fun create(
            @RequestBody rq: SetRecordRequest
    ): ResponseEntity<TxDto> {
        val id = contractService.setRecord(
                contractId = "5h3ma4vxZ73hrCcTqC9rbHnotmX3TsgusUsp4GUD1HuA",
                doctor_num = rq.doctor_num,
                record_num = rq.record_num,
                person_num = rq.person_num,
                level =  rq.level,
                content = rq.content
        )
        return ResponseEntity(TxDto(id), ACCEPTED)
    }
}

@RestController
@RequestMapping("public/get_record")
class GetRecordController(
        val contractService: ExampleContractService
) {

    @PostMapping
    fun create(
            @RequestBody rq: GetRecordRequest
    ): ResponseEntity<TxDto> {
        val id = contractService.getRecord(
                contractId = "5h3ma4vxZ73hrCcTqC9rbHnotmX3TsgusUsp4GUD1HuA",
                doctor_num = rq.doctor_num,
                record_num = rq.record_num,
                person_num = rq.person_num
        )
        return ResponseEntity(TxDto(id), ACCEPTED)
    }
}


@RestController
@RequestMapping("public/get_records")
class GetRecordsController(
        val contractService: ExampleContractService
) {

    @PostMapping
    fun create(
            @RequestBody rq: GetRecordsRequest
    ): ResponseEntity<TxDto> {
        val id = contractService.getRecords(
                contractId = "5h3ma4vxZ73hrCcTqC9rbHnotmX3TsgusUsp4GUD1HuA",
                doctor_num = rq.doctor_num,
                person_num = rq.person_num
        )
        return ResponseEntity(TxDto(id), ACCEPTED)
    }
}