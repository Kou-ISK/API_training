package com.example.api_training.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
data class StatsData(
    @JsonProperty("GET_STATS_DATA")
    var getStatsData: GetStatsData?,
)

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
data class StatsList(
    @JsonProperty("GET_STATS_List")
    var getStatsData: GetStatsData?,
)

@JsonSerialize
data class GetStatsData(
    @JsonProperty("RESULT")
    var result: Result?,
    @JsonProperty("PARAMETER")
    var parameter: Parameter?,
    @JsonProperty("STATISTICAL_DATA")
    var statisticalData: StatisticalData?,
)

@JsonSerialize
data class Result(
    @JsonProperty("STATUS")
    var status: String?,
    @JsonProperty("ERROR_MSG")
    var errorMessage: String?,
    @JsonProperty("DATE")
    var date: String?,
)

@JsonSerialize
data class Parameter(
    @JsonProperty("LANG")
    var lang: String?,
    @JsonProperty("STATS_DATA_ID")
    var statsDataId: String?,
    @JsonProperty("DATA_FORMAT")
    var dataFormat: String?,
    @JsonProperty("START_POSITION")
    var startPosition: String?,
    @JsonProperty("METAGET_FLG")
    var metaGetFlag: String?,
)

@JsonSerialize
data class StatisticalData(
    @JsonProperty("RESULT_INF")
    var resultInf: ResultInf?,
    @JsonProperty("TABLE_INF")
    var tableInf: TableInf?,
    @JsonProperty("CLASS_INF")
    var classInf: ClassInf?,
    @JsonProperty("DATA_INF")
    var dataInf: DataInf?,
)

@JsonSerialize
data class ResultInf(
    @JsonProperty("TOTAL_NUMBER")
    var totalNumber: Int?,
    @JsonProperty("FORM_NUMBER")
    var fromNumber: Int?,
    @JsonProperty("TO_NUMBER")
    var toNumber: Int?,
)

@JsonSerialize
data class TableInf(
    @JsonProperty("@id")
    var id: String?,
    @JsonProperty("STAT_NAME")
    var statName: CodeAndData?,
    @JsonProperty("GOV_ORG")
    var govOrg: CodeAndData?,
    @JsonProperty("STATISTICS_NAME")
    var statisticsName: String?,
    @JsonProperty("TITLE")
    var title: NumberAndData?,
    @JsonProperty("CYCLE")
    var cycle: String?,
    @JsonProperty("SURVEY_DATA")
    var surveyData: String?,
    @JsonProperty("SMALL_AREA")
    var smallArea: Int?,
    @JsonProperty("MAIN_CATEGORY")
    var mainCategory: CodeAndData?,
    @JsonProperty("SUB_CATEGORY")
    var subCategory: CodeAndData?,
    @JsonProperty("OVERALL_TOTAL_NUMBER")
    var overAllTotalNumber: Int?,
    @JsonProperty("UPDATED_DATE")
    var updatedDate: String?,
)

@JsonSerialize
data class ClassInf(
    @JsonProperty("CLASS_OBJ")
    var classObjList: List<ClassObj>?,
)

@JsonSerialize
data class DataInf(
    var note: Note,
    var value: Value,
)

@JsonSerialize
data class Note(
    @JsonProperty("@char")
    var char: String,
    @JsonProperty("@$")
    var value: String,
)

@JsonSerialize
data class Value(
    @JsonProperty("@cat01")
    var cat: String,
    @JsonProperty("@area")
    var area: String,
    @JsonProperty("@time")
    var time: String,
    @JsonProperty("@unit")
    var unit: String,
    @JsonProperty("$")
    var value: String,
)

@JsonSerialize
data class ClassObj(
    @JsonProperty("@id")
    var id: String?,
    @JsonProperty("@name")
    var name: String?,
    @JsonProperty("CLASS")
    var classArray: List<ClassOfData>?,
)

@JsonSerialize
data class ClassOfData(
    @JsonProperty("@code")
    var code: String?,
    @JsonProperty("@name")
    var name: String?,
    @JsonProperty("@level")
    var level: String?,
    @JsonProperty("@unit")
    var unit: String?,
)

@JsonSerialize
data class CodeAndData(
    @JsonProperty("@code")
    var code: String?,
    @JsonProperty("$")
    var data: String?,
)

@JsonSerialize
data class NumberAndData(
    @JsonProperty("@no")
    var number: String?,
    @JsonProperty("$")
    var data: String?,
)