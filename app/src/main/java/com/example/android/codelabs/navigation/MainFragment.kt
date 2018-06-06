/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.codelabs.navigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController

/**
 * Fragment used to show how to navigate to another destination
 */
class MainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //TODO STEP 5 - Set an OnClickListener, using Navigation.createNavigateOnClickListener()
        view.findViewById<Button>(R.id.navigate_dest_bt)?.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.flow_step_one, null)
        )
        //TODO ENDSTEP 5

        //TODO STEP 6 - Set NavOptions

        val options = NavOptions.Builder()
            .setEnterAnim(R.anim.slide_in_right)
            .setExitAnim(R.anim.slide_out_left)
            .setPopEnterAnim(R.anim.slide_in_left)
            .setPopExitAnim(R.anim.slide_out_right)
            .build()
//
        view.findViewById<Button>(R.id.navigate_dest_bt)?.setOnClickListener {
            findNavController(it).navigate(R.id.flow_step_one, null, options)
        }
        //TODO ENDSTEP 6

        //TODO STEP 7 - Update the OnClickListener to navigate using an action
        view.findViewById<Button>(R.id.navigate_action_bt)?.setOnClickListener {
            test()
            testTwo()
            Navigation.createNavigateOnClickListener(R.id.flow_step_two, null)
        }

        //TODO ENDSTEP 7
        test()
        testTwo()
    }

    fun test() : Int{
        listOf(1,2,3,4,5).forEach{
            if (it == 3){
                return it
            }
            print("cannot reach it")
        }
        return 0
    }

     val TAG: String? = "MainFragment.this";

    /**
     * lambda 表达式中返回，需要标记
     */
    fun testTwo(){
        listOf(1,2,3,4,5).forEach lit@{
            if (it == 3) {
                return lit@
                print("cannot reach it")
            }
        }
    }

    fun test03(){
        intArrayOf(1,2,3).iterator().forEach { print(it) }

        var name = "test"

        print("${name}"+"${intArrayOf(2,3,4).size}")



        var list = listOf(3,4,5)

        for (i in 0 until list.size){
            print(i)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.main_menu, menu)
    }
}
