package com.example.poketracker;

import android.provider.BaseColumns;

public class MyDataContract {
    public static final class MyDataEntry implements BaseColumns {
        public static final String TABLE_NAME = "PokeTracker";
        public static final int NATIONAL_NUMBER = 0;
        public static final String NAME = "pokemon_name";
        public static final String SPECIES = "pokemon_species";
        public static final float HEIGHT = 0.0f;
        public static final float WEIGHT = 0.0f;
        public static final int HP = 0;
        public static final int ATTACK = 0;
        public static final int DEFENSE = 0;
    }
}
