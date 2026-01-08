package com.example.kotlinjc_theme

import kotlinx.serialization.Serializable

interface AppRoute

@Serializable
object Settings : AppRoute


@Serializable
object Data : AppRoute

