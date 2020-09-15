package com.deneb.epicsevenappdb.features.heros.model


import com.google.gson.annotations.SerializedName

data class ResultHeroApi(
    @SerializedName("results")
    val results: List<Result> = listOf(),
    @SerializedName("meta")
    val meta: Meta = Meta()
) {
    data class Result(
        @SerializedName("_id")
        val _id: String = "",
        @SerializedName("id")
        val id: String = "",
        @SerializedName("name")
        val name: String = "",
        @SerializedName("moonlight")
        val moonlight: Boolean = false,
        @SerializedName("rarity")
        val rarity: Int = 0,
        @SerializedName("attribute")
        val attribute: String = "",
        @SerializedName("role")
        val role: String = "",
        @SerializedName("zodiac")
        val zodiac: String = "",
        @SerializedName("description")
        val description: String = "",
        @SerializedName("story")
        val story: String = "",
        @SerializedName("get_line")
        val getLine: String = "",
        @SerializedName("stats")
        val stats: Stats = Stats(),
        @SerializedName("relationships")
        val relationships: List<Relationship> = listOf(),
        @SerializedName("self_devotion")
        val selfDevotion: SelfDevotion = SelfDevotion(),
        @SerializedName("devotion")
        val devotion: Devotion = Devotion(),
        @SerializedName("specialty")
        val specialty: Specialty = Specialty(),
        @SerializedName("camping")
        val camping: Camping = Camping(),
        @SerializedName("zodiac_tree")
        val zodiacTree: List<ZodiacTree> = listOf(),
        @SerializedName("skills")
        val skills: List<Skill> = listOf(),
        @SerializedName("specialty_change")
        val specialtyChange: SpecialtyChange = SpecialtyChange(),
        @SerializedName("assets")
        val assets: Assets = Assets(),
        @SerializedName("buffs")
        val buffs: List<Buff> = listOf(),
        @SerializedName("debuffs")
        val debuffs: List<Debuff> = listOf(),
        @SerializedName("common")
        val common: List<Common> = listOf(),
        @SerializedName("ex_equip")
        val exEquip: List<ExEquip> = listOf(),
        @SerializedName("calculatedStatus")
        val calculatedStatus: CalculatedStatus = CalculatedStatus()
    ) {
        data class Stats(
            @SerializedName("bra")
            val bra: Int = 0,
            @SerializedName("int")
            val int: Int = 0,
            @SerializedName("fai")
            val fai: Int = 0,
            @SerializedName("des")
            val des: Int = 0
        )

        data class Relationship(
            @SerializedName("name")
            val name: String = "",
            @SerializedName("description")
            val description: String = "",
            @SerializedName("relations")
            val relations: List<Relation> = listOf()
        ) {
            data class Relation(
                @SerializedName("id")
                val id: String = "",
                @SerializedName("slot")
                val slot: Int = 0,
                @SerializedName("description")
                val description: String = "",
                @SerializedName("relation")
                val relation: String = "",
                @SerializedName("upgrade")
                val upgrade: Upgrade = Upgrade(),
                @SerializedName("relation_id")
                val relationId: String = ""
            ) {
                class Upgrade(
                )
            }
        }

        data class SelfDevotion(
            @SerializedName("type")
            val type: String = "",
            @SerializedName("grades")
            val grades: Grades = Grades()
        ) {
            data class Grades(
                @SerializedName("B")
                val b: Double = 0.0,
                @SerializedName("A")
                val a: Double = 0.0,
                @SerializedName("S")
                val s: Double = 0.0,
                @SerializedName("SS")
                val sS: Double = 0.0,
                @SerializedName("SSS")
                val sSS: Double = 0.0
            )
        }

        data class Devotion(
            @SerializedName("type")
            val type: String = "",
            @SerializedName("grades")
            val grades: Grades = Grades(),
            @SerializedName("slots")
            val slots: Slots = Slots()
        ) {
            data class Grades(
                @SerializedName("B")
                val b: Double = 0.0,
                @SerializedName("A")
                val a: Double = 0.0,
                @SerializedName("S")
                val s: Double = 0.0,
                @SerializedName("SS")
                val sS: Double = 0.0,
                @SerializedName("SSS")
                val sSS: Double = 0.0
            )

            data class Slots(
                @SerializedName("1")
                val x1: Boolean = false,
                @SerializedName("2")
                val x2: Boolean = false,
                @SerializedName("3")
                val x3: Boolean = false,
                @SerializedName("4")
                val x4: Boolean = false
            )
        }

        data class Specialty(
            @SerializedName("name")
            val name: String = "",
            @SerializedName("description")
            val description: String = "",
            @SerializedName("effect_type")
            val effectType: String = "",
            @SerializedName("effect_value")
            val effectValue: Double = 0.0,
            @SerializedName("command")
            val command: Int = 0,
            @SerializedName("charm")
            val charm: Int = 0,
            @SerializedName("politics")
            val politics: Int = 0,
            @SerializedName("type")
            val type: Type = Type(),
            @SerializedName("assets")
            val assets: Assets = Assets()
        ) {
            class Type(
            )

            data class Assets(
                @SerializedName("icon")
                val icon: String = ""
            )
        }

        data class Camping(
            @SerializedName("personalities")
            val personalities: List<String> = listOf(),
            @SerializedName("topics")
            val topics: List<String> = listOf(),
            @SerializedName("values")
            val values: Values = Values()
        ) {
            data class Values(
                @SerializedName("Criticism")
                val criticism: Int = 0,
                @SerializedName("Reality Check")
                val realityCheck: Int = 0,
                @SerializedName("Heroic Tale")
                val heroicTale: Int = 0,
                @SerializedName("Comforting Cheer")
                val comfortingCheer: Int = 0,
                @SerializedName("Cute Cheer")
                val cuteCheer: Int = 0,
                @SerializedName("Heroic Cheer")
                val heroicCheer: Int = 0,
                @SerializedName("Sad Memory")
                val sadMemory: Int = 0,
                @SerializedName("Joyful Memory")
                val joyfulMemory: Int = 0,
                @SerializedName("Happy Memory")
                val happyMemory: Int = 0,
                @SerializedName("Unique Comment")
                val uniqueComment: Int = 0,
                @SerializedName("Self-Indulgent")
                val selfIndulgent: Int = 0,
                @SerializedName("Occult")
                val occult: Int = 0,
                @SerializedName("Myth")
                val myth: Int = 0,
                @SerializedName("Bizarre Story")
                val bizarreStory: Int = 0,
                @SerializedName("Food Story")
                val foodStory: Int = 0,
                @SerializedName("Horror Story")
                val horrorStory: Int = 0,
                @SerializedName("Gossip")
                val gossip: Int = 0,
                @SerializedName("Dream")
                val dream: Int = 0,
                @SerializedName("Advice")
                val advice: Int = 0,
                @SerializedName("Complain")
                val complain: Int = 0,
                @SerializedName("Belief")
                val belief: Int = 0,
                @SerializedName("Interesting Story")
                val interestingStory: Int = 0
            )
        }

        data class ZodiacTree(
            @SerializedName("name")
            val name: String = "",
            @SerializedName("description")
            val description: String = "",
            @SerializedName("skill_enhanced")
            val skillEnhanced: Any? = Any(),
            @SerializedName("costs")
            val costs: List<Cost> = listOf(),
            @SerializedName("stats")
            val stats: List<Stat> = listOf(),
            @SerializedName("_id")
            val id: String = ""
        ) {
            data class Cost(
                @SerializedName("item")
                val item: String = "",
                @SerializedName("count")
                val count: Int = 0,
                @SerializedName("_id")
                val id: String = "",
                @SerializedName("identifier")
                val identifier: String = "",
                @SerializedName("name")
                val name: String = "",
                @SerializedName("description")
                val description: String = "",
                @SerializedName("category")
                val category: String = "",
                @SerializedName("attribute")
                val attribute: String? = "",
                @SerializedName("grade")
                val grade: Int = 0,
                @SerializedName("type1")
                val type1: String = "",
                @SerializedName("type2")
                val type2: Any? = Any(),
                @SerializedName("assets")
                val assets: Assets = Assets(),
                @SerializedName("request_count")
                val requestCount: Int = 0,
                @SerializedName("support_count")
                val supportCount: Int = 0
            ) {
                data class Assets(
                    @SerializedName("thumbnail")
                    val thumbnail: Any? = Any(),
                    @SerializedName("icon")
                    val icon: String = ""
                )
            }

            data class Stat(
                @SerializedName("stat")
                val stat: String = "",
                @SerializedName("value")
                val value: Double = 0.0,
                @SerializedName("type")
                val type: String = ""
            )
        }

        data class Skill(
            @SerializedName("name")
            val name: String = "",
            @SerializedName("can_enhance")
            val canEnhance: Boolean = false,
            @SerializedName("description")
            val description: String = "",
            @SerializedName("values")
            val values: List<Double> = listOf(),
            @SerializedName("passive")
            val passive: Boolean = false,
            @SerializedName("cooldown")
            val cooldown: Int = 0,
            @SerializedName("soul_gain")
            val soulGain: Int = 0,
            @SerializedName("pow")
            val pow: Double = 0.0,
            @SerializedName("att_rate")
            val attRate: Double = 0.0,
            @SerializedName("buff")
            val buff: List<Int> = listOf(),
            @SerializedName("debuff")
            val debuff: List<Int> = listOf(),
            @SerializedName("common")
            val common: List<Int> = listOf(),
            @SerializedName("enhancements")
            val enhancements: List<Enhancement> = listOf(),
            @SerializedName("_id")
            val id: String = "",
            @SerializedName("assets")
            val assets: Assets = Assets(),
            @SerializedName("enhanced_description")
            val enhancedDescription: String = "",
            @SerializedName("soul_description")
            val soulDescription: String = "",
            @SerializedName("soul_requirement")
            val soulRequirement: Int = 0,
            @SerializedName("soul_pow")
            val soulPow: Double = 0.0,
            @SerializedName("soul_att_rate")
            val soulAttRate: Double = 0.0
        ) {
            data class Enhancement(
                @SerializedName("string")
                val string: String = "",
                @SerializedName("costs")
                val costs: List<Cost> = listOf(),
                @SerializedName("_id")
                val id: String = ""
            ) {
                data class Cost(
                    @SerializedName("item")
                    val item: String = "",
                    @SerializedName("count")
                    val count: Int = 0,
                    @SerializedName("_id")
                    val id: String = "",
                    @SerializedName("identifier")
                    val identifier: String = "",
                    @SerializedName("name")
                    val name: String = "",
                    @SerializedName("description")
                    val description: String = "",
                    @SerializedName("assets")
                    val assets: Assets = Assets(),
                    @SerializedName("category")
                    val category: String = "",
                    @SerializedName("attribute")
                    val attribute: Any? = Any(),
                    @SerializedName("grade")
                    val grade: Int = 0,
                    @SerializedName("type1")
                    val type1: String = "",
                    @SerializedName("type2")
                    val type2: Any? = Any(),
                    @SerializedName("request_count")
                    val requestCount: Int = 0,
                    @SerializedName("support_count")
                    val supportCount: Int = 0
                ) {
                    data class Assets(
                        @SerializedName("icon")
                        val icon: String = "",
                        @SerializedName("thumbnail")
                        val thumbnail: Any? = Any()
                    )
                }
            }

            data class Assets(
                @SerializedName("icon")
                val icon: String = ""
            )
        }

        class SpecialtyChange(
        )

        data class Assets(
            @SerializedName("icon")
            val icon: String = "",
            @SerializedName("image")
            val image: String = "",
            @SerializedName("thumbnail")
            val thumbnail: String = ""
        )

        data class Buff(
            @SerializedName("_id")
            val _id: String = "",
            @SerializedName("id")
            val id: Int = 0,
            @SerializedName("type")
            val type: String = "",
            @SerializedName("name")
            val name: String = "",
            @SerializedName("effect")
            val effect: String = "",
            @SerializedName("assets")
            val assets: Assets = Assets()
        ) {
            data class Assets(
                @SerializedName("icon")
                val icon: String = ""
            )
        }

        data class Debuff(
            @SerializedName("_id")
            val _id: String = "",
            @SerializedName("id")
            val id: Int = 0,
            @SerializedName("type")
            val type: String = "",
            @SerializedName("name")
            val name: String = "",
            @SerializedName("effect")
            val effect: String = "",
            @SerializedName("assets")
            val assets: Assets = Assets()
        ) {
            data class Assets(
                @SerializedName("icon")
                val icon: String = ""
            )
        }

        data class Common(
            @SerializedName("_id")
            val _id: String = "",
            @SerializedName("id")
            val id: Int = 0,
            @SerializedName("type")
            val type: String = "",
            @SerializedName("name")
            val name: String = "",
            @SerializedName("effect")
            val effect: String = "",
            @SerializedName("assets")
            val assets: Assets = Assets()
        ) {
            data class Assets(
                @SerializedName("icon")
                val icon: Any? = Any()
            )
        }

        data class ExEquip(
            @SerializedName("_id")
            val _id: String = "",
            @SerializedName("id")
            val id: String = "",
            @SerializedName("name")
            val name: String = "",
            @SerializedName("description")
            val description: String = "",
            @SerializedName("unit")
            val unit: String = "",
            @SerializedName("role")
            val role: String = "",
            @SerializedName("rarity")
            val rarity: Int = 0,
            @SerializedName("stat")
            val stat: Stat = Stat(),
            @SerializedName("skills")
            val skills: List<Skill> = listOf(),
            @SerializedName("assets")
            val assets: Assets = Assets()
        ) {
            data class Stat(
                @SerializedName("type")
                val type: String = "",
                @SerializedName("value")
                val value: Double = 0.0
            )

            data class Skill(
                @SerializedName("skill")
                val skill: Int = 0,
                @SerializedName("description")
                val description: String = "",
                @SerializedName("skill_description")
                val skillDescription: String = "",
                @SerializedName("values")
                val values: List<Int> = listOf(),
                @SerializedName("_id")
                val id: Int = 0
            )

            data class Assets(
                @SerializedName("icon")
                val icon: String = ""
            )
        }

        data class CalculatedStatus(
            @SerializedName("lv50FiveStarNoAwaken")
            val lv50FiveStarNoAwaken: Lv50FiveStarNoAwaken = Lv50FiveStarNoAwaken(),
            @SerializedName("lv50FiveStarFullyAwakened")
            val lv50FiveStarFullyAwakened: Lv50FiveStarFullyAwakened = Lv50FiveStarFullyAwakened(),
            @SerializedName("lv60SixStarNoAwaken")
            val lv60SixStarNoAwaken: Lv60SixStarNoAwaken = Lv60SixStarNoAwaken(),
            @SerializedName("lv60SixStarFullyAwakened")
            val lv60SixStarFullyAwakened: Lv60SixStarFullyAwakened = Lv60SixStarFullyAwakened()
        ) {
            data class Lv50FiveStarNoAwaken(
                @SerializedName("cp")
                val cp: Int = 0,
                @SerializedName("atk")
                val atk: Int = 0,
                @SerializedName("hp")
                val hp: Int = 0,
                @SerializedName("spd")
                val spd: Int = 0,
                @SerializedName("def")
                val def: Int = 0,
                @SerializedName("chc")
                val chc: Double = 0.0,
                @SerializedName("chd")
                val chd: Double = 0.0,
                @SerializedName("dac")
                val dac: Double = 0.0,
                @SerializedName("eff")
                val eff: Int = 0,
                @SerializedName("efr")
                val efr: Int = 0
            )

            data class Lv50FiveStarFullyAwakened(
                @SerializedName("cp")
                val cp: Int = 0,
                @SerializedName("atk")
                val atk: Int = 0,
                @SerializedName("hp")
                val hp: Int = 0,
                @SerializedName("spd")
                val spd: Int = 0,
                @SerializedName("def")
                val def: Int = 0,
                @SerializedName("chc")
                val chc: Double = 0.0,
                @SerializedName("chd")
                val chd: Double = 0.0,
                @SerializedName("dac")
                val dac: Double = 0.0,
                @SerializedName("eff")
                val eff: Double = 0.0,
                @SerializedName("efr")
                val efr: Int = 0
            )

            data class Lv60SixStarNoAwaken(
                @SerializedName("cp")
                val cp: Int = 0,
                @SerializedName("atk")
                val atk: Int = 0,
                @SerializedName("hp")
                val hp: Int = 0,
                @SerializedName("spd")
                val spd: Int = 0,
                @SerializedName("def")
                val def: Int = 0,
                @SerializedName("chc")
                val chc: Double = 0.0,
                @SerializedName("chd")
                val chd: Double = 0.0,
                @SerializedName("dac")
                val dac: Double = 0.0,
                @SerializedName("eff")
                val eff: Int = 0,
                @SerializedName("efr")
                val efr: Int = 0
            )

            data class Lv60SixStarFullyAwakened(
                @SerializedName("cp")
                val cp: Int = 0,
                @SerializedName("atk")
                val atk: Int = 0,
                @SerializedName("hp")
                val hp: Int = 0,
                @SerializedName("spd")
                val spd: Int = 0,
                @SerializedName("def")
                val def: Int = 0,
                @SerializedName("chc")
                val chc: Double = 0.0,
                @SerializedName("chd")
                val chd: Double = 0.0,
                @SerializedName("dac")
                val dac: Double = 0.0,
                @SerializedName("eff")
                val eff: Double = 0.0,
                @SerializedName("efr")
                val efr: Int = 0
            )
        }
    }

    data class Meta(
        @SerializedName("requestDate")
        val requestDate: String = "",
        @SerializedName("apiVersion")
        val apiVersion: String = ""
    )
}