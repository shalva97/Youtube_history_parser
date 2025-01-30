package icons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

public val Icons.Eye: ImageVector
    get() {
        if (_eye != null) {
            return _eye!!
        }
        _eye = Builder(
            name = "Eye",
            defaultWidth = 16.0.dp,
            defaultHeight = 10.0.dp,
            viewportWidth = 16.0f,
            viewportHeight = 10.0f
                      ).apply {
            path(
                fill = SolidColor(Color(0xFF2E2B2B)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = EvenOdd
                ) {
                moveTo(2.065f, 5.137f)
                curveTo(2.031f, 5.069f, 2.014f, 5.024f, 2.006f, 5.0f)
                curveTo(2.014f, 4.976f, 2.031f, 4.931f, 2.065f, 4.863f)
                curveTo(2.131f, 4.731f, 2.238f, 4.56f, 2.389f, 4.359f)
                curveTo(2.692f, 3.959f, 3.141f, 3.483f, 3.705f, 3.027f)
                curveTo(4.842f, 2.108f, 6.365f, 1.333f, 8.0f, 1.333f)
                curveTo(9.635f, 1.333f, 11.158f, 2.108f, 12.295f, 3.027f)
                curveTo(12.859f, 3.483f, 13.309f, 3.959f, 13.611f, 4.359f)
                curveTo(13.762f, 4.56f, 13.869f, 4.731f, 13.935f, 4.863f)
                curveTo(13.969f, 4.931f, 13.986f, 4.976f, 13.994f, 5.0f)
                curveTo(13.986f, 5.024f, 13.969f, 5.069f, 13.935f, 5.137f)
                curveTo(13.869f, 5.269f, 13.762f, 5.44f, 13.611f, 5.641f)
                curveTo(13.309f, 6.041f, 12.859f, 6.517f, 12.295f, 6.973f)
                curveTo(11.158f, 7.892f, 9.635f, 8.667f, 8.0f, 8.667f)
                curveTo(6.365f, 8.667f, 4.842f, 7.892f, 3.705f, 6.973f)
                curveTo(3.141f, 6.517f, 2.692f, 6.041f, 2.389f, 5.641f)
                curveTo(2.238f, 5.44f, 2.131f, 5.269f, 2.065f, 5.137f)
                close()
                moveTo(8.0f, 0.0f)
                curveTo(5.954f, 0.0f, 4.143f, 0.959f, 2.867f, 1.99f)
                curveTo(2.225f, 2.509f, 1.698f, 3.062f, 1.325f, 3.556f)
                curveTo(1.139f, 3.802f, 0.984f, 4.043f, 0.872f, 4.267f)
                curveTo(0.77f, 4.471f, 0.667f, 4.733f, 0.667f, 5.0f)
                curveTo(0.667f, 5.267f, 0.77f, 5.529f, 0.872f, 5.733f)
                curveTo(0.984f, 5.957f, 1.139f, 6.198f, 1.325f, 6.444f)
                curveTo(1.698f, 6.938f, 2.225f, 7.491f, 2.867f, 8.01f)
                curveTo(4.143f, 9.041f, 5.954f, 10.0f, 8.0f, 10.0f)
                curveTo(10.046f, 10.0f, 11.857f, 9.041f, 13.133f, 8.01f)
                curveTo(13.775f, 7.491f, 14.302f, 6.938f, 14.675f, 6.444f)
                curveTo(14.861f, 6.198f, 15.016f, 5.957f, 15.128f, 5.733f)
                curveTo(15.23f, 5.529f, 15.333f, 5.267f, 15.333f, 5.0f)
                curveTo(15.333f, 4.733f, 15.23f, 4.471f, 15.128f, 4.267f)
                curveTo(15.016f, 4.043f, 14.861f, 3.802f, 14.675f, 3.556f)
                curveTo(14.302f, 3.062f, 13.775f, 2.509f, 13.133f, 1.99f)
                curveTo(11.857f, 0.959f, 10.046f, 0.0f, 8.0f, 0.0f)
                close()
                moveTo(6.667f, 5.0f)
                curveTo(6.667f, 4.264f, 7.264f, 3.667f, 8.0f, 3.667f)
                curveTo(8.736f, 3.667f, 9.333f, 4.264f, 9.333f, 5.0f)
                curveTo(9.333f, 5.736f, 8.736f, 6.333f, 8.0f, 6.333f)
                curveTo(7.264f, 6.333f, 6.667f, 5.736f, 6.667f, 5.0f)
                close()
                moveTo(8.0f, 2.333f)
                curveTo(6.527f, 2.333f, 5.333f, 3.527f, 5.333f, 5.0f)
                curveTo(5.333f, 6.473f, 6.527f, 7.667f, 8.0f, 7.667f)
                curveTo(9.473f, 7.667f, 10.667f, 6.473f, 10.667f, 5.0f)
                curveTo(10.667f, 3.527f, 9.473f, 2.333f, 8.0f, 2.333f)
                close()
            }
        }
            .build()
        return _eye!!
    }

private var _eye: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = Icons.Eye, contentDescription = null)
    }
}
