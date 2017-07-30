package com.example.peter.prefectures_kotlin

/**
 * Prefectureクラス

 * @author :ryo.yamada
 * *
 * @since :1.0 :2017/07/28
 */
class Prefecture {

    /** 都道府県名  */
    /**
     * 都道府県名を取得
     * @return prefName 都道府県名
     */
    /**
     * 都道府県名をセット
     * @param prefName 都道府県名
     */
    var prefName: String? = null
    /** チェック状態 */
    /**
     * チェック状態を取得
     * @return isSelected チェック状態
     */
    /**
     * チェック状態をセット
     * @param selected チェック状態
     */
    var isSelected: Boolean = false

    /** 空のコンストラクタ  */
    constructor() {}

    /** コンストラクタ  */
    constructor(prefName: String, isSelected: Boolean) {
        this.prefName = prefName
        this.isSelected = isSelected
    }
}
