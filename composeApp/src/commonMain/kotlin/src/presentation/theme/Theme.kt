package src.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)


@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit
) {
    val colorScheme = when {
        darkTheme -> darkScheme
        else -> lightScheme
    }

    val notoNastaliqUrduFontFamily = NotoNastaliqUrduFontFamily()

    val defaultTypography = MaterialTheme.typography
    val typography = Typography(
        displayLarge = defaultTypography.displayLarge.copy(fontFamily = notoNastaliqUrduFontFamily),
        displayMedium = defaultTypography.displayMedium.copy(fontFamily = notoNastaliqUrduFontFamily),
        displaySmall = defaultTypography.displaySmall.copy(fontFamily = notoNastaliqUrduFontFamily),
        headlineLarge = defaultTypography.headlineLarge.copy(fontFamily = notoNastaliqUrduFontFamily),
        headlineMedium = defaultTypography.headlineMedium.copy(fontFamily = notoNastaliqUrduFontFamily),
        headlineSmall = defaultTypography.headlineSmall.copy(fontFamily = notoNastaliqUrduFontFamily),
        titleLarge = defaultTypography.titleLarge.copy(fontFamily = notoNastaliqUrduFontFamily),
        titleMedium = defaultTypography.titleMedium.copy(fontFamily = notoNastaliqUrduFontFamily),
        titleSmall = defaultTypography.titleSmall.copy(fontFamily = notoNastaliqUrduFontFamily),
        bodyLarge = defaultTypography.bodyLarge.copy(fontFamily = notoNastaliqUrduFontFamily),
        bodyMedium = defaultTypography.bodyMedium.copy(fontFamily = notoNastaliqUrduFontFamily),
        bodySmall = defaultTypography.bodySmall.copy(fontFamily = notoNastaliqUrduFontFamily),
        labelLarge = defaultTypography.labelLarge.copy(fontFamily = notoNastaliqUrduFontFamily),
        labelMedium = defaultTypography.labelMedium.copy(fontFamily = notoNastaliqUrduFontFamily),
        labelSmall = defaultTypography.labelSmall.copy(fontFamily = notoNastaliqUrduFontFamily)
    )

    val shapes = MaterialTheme.shapes.copy(
        extraSmall = RoundedCornerShape(8.dp),
        small = RoundedCornerShape(8.dp),
        medium = RoundedCornerShape(8.dp),
        large = RoundedCornerShape(8.dp),
        extraLarge = RoundedCornerShape(8.dp),
    )

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = shapes,
        typography = typography,
        content = content,
    )
}

