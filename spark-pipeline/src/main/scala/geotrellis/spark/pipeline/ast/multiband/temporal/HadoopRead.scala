package geotrellis.spark.pipeline.ast.multiband.temporal

import io.circe.syntax._

import geotrellis.raster._
import geotrellis.spark.TemporalProjectedExtent
import geotrellis.spark.pipeline.ast.Input
import geotrellis.spark.pipeline.json.read
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD

case class HadoopRead(arg: read.JsonRead) extends Input[RDD[(TemporalProjectedExtent, MultibandTile)]] {
  def asJson = arg.asJson :: Nil
  def eval(implicit sc: SparkContext): RDD[(TemporalProjectedExtent, MultibandTile)] = Input.temporalMultibandHadoop(arg)
}
