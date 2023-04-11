package com.example.api_training.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonSerialize

@JsonSerialize
//@JsonInclude(JsonInclude.Include.NON_NULL)
data class StatsData(
    @JsonProperty("GET_STATS_DATA")
    val getStatsData: GetStatsData?,
)

@JsonSerialize
//@JsonInclude(JsonInclude.Include.NON_NULL)
data class StatsList(
    @JsonProperty("GET_STATS_LIST")
    val getStatsData: GetStatsData?,
)

@JsonSerialize
data class GetStatsData(
    @JsonProperty("RESULT")
    val result: Result?,
    @JsonProperty("PARAMETER")
    val parameter: Parameter?,
    @JsonProperty("STATISTICAL_DATA")
    val statisticalData: StatisticalData?,
)

@JsonSerialize
data class Result(
    @JsonProperty("STATUS")
    val status: String?,
    @JsonProperty("ERROR_MSG")
    val errorMessage: String?,
    @JsonProperty("DATE")
    val date: String?,
)

@JsonSerialize
data class Parameter(
    @JsonProperty("LANG")
    val lang: String?,
    @JsonProperty("STATS_DATA_ID")
    val statsDataId: String?,
    @JsonProperty("DATA_FORMAT")
    val dataFormat: String?,
    @JsonProperty("START_POSITION")
    val startPosition: String?,
    @JsonProperty("METAGET_FLG")
    val metaGetFlag: String?,
)

@JsonSerialize
data class StatisticalData(
    @JsonProperty("RESULT_INF")
    val resultInf: ResultInf?,
    @JsonProperty("TABLE_INF")
    val tableInf: TableInf?,
    @JsonProperty("CLASS_INF")
    val classInf: ClassInf?,
    @JsonProperty("DATA_INF")
    val dataInf: DataInf?,
)

@JsonSerialize
data class ResultInf(
    @JsonProperty("TOTAL_NUMBER")
    val totalNumber: Int?,
    @JsonProperty("FORM_NUMBER")
    val fromNumber: Int?,
    @JsonProperty("TO_NUMBER")
    val toNumber: Int?,
)

@JsonSerialize
data class TableInf(
    @JsonProperty("@id")
    val id: String?,
    @JsonProperty("STAT_NAME")
    val statName: GovOrg?,
    @JsonProperty("GOV_ORG")
    val govOrg: CodeAndData?,
    @JsonProperty("STATISTICS_NAME")
    val statisticsName: String?,
    @JsonProperty("TITLE")
    val title: NumberAndData?,
    @JsonProperty("CYCLE")
    val cycle: String?,
    @JsonProperty("SURVEY_DATE")
    val surveyDate: String?,
    @JsonProperty("OPEN_DATE")
    val openDate: String?,
    @JsonProperty("SMALL_AREA")
    val smallArea: Int?,
    @JsonProperty("MAIN_CATEGORY")
    val mainCategory: MainCategory?,
    @JsonProperty("SUB_CATEGORY")
    val subCategory: SubCategory?,
    @JsonProperty("OVERALL_TOTAL_NUMBER")
    val overAllTotalNumber: Int?,
    @JsonProperty("UPDATED_DATE")
    val updatedDate: String?,
)

@JsonSerialize
data class ClassInf(
    @JsonProperty("CLASS_OBJ")
    val classObjList: List<ClassObj>?,
)

@JsonSerialize
data class DataInf(
    @JsonProperty("NOTE")
    val note: Note,
    @JsonProperty("VALUE")
    val value: Value,
)

@JsonSerialize
data class Note(
    @JsonProperty("@char")
    val char: String,
    @JsonProperty("$")
    val value: String,
)

@JsonSerialize
data class Value(
    @JsonProperty("@cat01")
    val cat: String,
    @JsonProperty("@area")
    val area: String,
    @JsonProperty("@time")
    val time: String,
    @JsonProperty("@unit")
    val unit: String,
    @JsonProperty("$")
    val value: String,
)

@JsonSerialize
data class ClassObj(
    @JsonProperty("@id")
    val id: String?,
    @JsonProperty("@name")
    val name: String?,
    @JsonProperty("CLASS")
    val classArray: List<ClassOfData>?,
)

@JsonSerialize
data class ClassOfData(
    @JsonProperty("@code")
    val code: String?,
    @JsonProperty("@name")
    val name: String?,
    @JsonProperty("@level")
    val level: String?,
    @JsonProperty("@unit")
    val unit: String?,
)

@JsonSerialize
data class GovOrg(
    @JsonProperty("@code")
    val code: String?,
    @JsonProperty("$")
    val data: String?,
)

@JsonSerialize
data class CodeAndData(
    @JsonProperty("@code")
    val code: String?,
    @JsonProperty("$")
    val data: String?,
)

@JsonSerialize
data class MainCategory(
    @JsonProperty("@code")
    val code: String?,
    @JsonProperty("$")
    val data: String?,
)

@JsonSerialize
data class SubCategory(
    @JsonProperty("@code")
    val code: String?,
    @JsonProperty("$")
    val data: String?,
)

@JsonSerialize
data class NumberAndData(
    @JsonProperty("@no")
    val number: String?,
    @JsonProperty("$")
    val data: String?,
)