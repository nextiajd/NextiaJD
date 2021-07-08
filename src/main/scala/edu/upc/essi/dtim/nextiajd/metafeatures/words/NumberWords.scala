package edu.upc.essi.dtim.nextiajd.metafeatures.words

import edu.upc.essi.dtim.nextiajd.metafeatures.{DefaultMF, MetaFeature}
import edu.upc.essi.dtim.nextiajd.utils.{AggregationDataEnum, DataTypeProfilesEnum, NormalizationTypeEnum}
import org.apache.spark.sql.Column
import org.apache.spark.sql.functions.sum

object NumberWords extends MetaFeature with DefaultMF{
  val name: String = "words"
  val nameAtt: String = "numberWords"
  val dataType: String = DataTypeProfilesEnum.string
  val aggregatedData: String = AggregationDataEnum.countWords
  val normalize: Boolean = true
  val normalizeType: Int = NormalizationTypeEnum.zero
  val doc: String = "Number of words in the attribute"

  def func(columnName: String): Column = sum(columnName).as(s"${columnName}_${nameAtt}")
}
