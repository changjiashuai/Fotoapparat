package io.fotoapparat.routine.focus

import io.fotoapparat.hardware.CameraDevice
import io.fotoapparat.hardware.Device
import io.fotoapparat.result.FocusResult
import io.fotoapparat.test.willReturn
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals

@RunWith(MockitoJUnitRunner::class)
internal class FocusRoutineTest {

    @Mock
    lateinit var cameraDevice: CameraDevice
    @Mock
    lateinit var device: Device

    @Test
    fun Focus() = runBlocking {
        // Given
        device.awaitSelectedCamera() willReturn cameraDevice
        cameraDevice.autoFocus() willReturn FocusResult.Focused

        // When
        val focusResult = device.focus()

        // Then
        assertEquals(
                expected = FocusResult.Focused,
                actual = focusResult
        )
    }

}