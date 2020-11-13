package org.example;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class ExampleMapperTest {

  private final static ExampleSourceVO SOURCE1 = ImmutableExampleSourceVO.builder().setBirthday(LocalDate.of(2001, 10, 02)).build();
  private final static ExampleSourceVO SOURCE2 = ImmutableExampleSourceVO.builder().setBirthday(LocalDate.of(2011, 11, 02)).build();

  private final static ExampleMember MEMBER1 = new ExampleMember("Carla");
  private final static ExampleMember MEMBER2 = new ExampleMember("Christine");

  private final ExampleMapper underTest = new ExampleMapperImpl();

  @Test
  void testCreation() {
    ExampleTarget result = underTest.create(SOURCE1, MEMBER1);

    assertThat(result.getBirthday()).isEqualTo(SOURCE1.getBirthday());
    assertThat(result.getMember()).isNotNull();
    assertThat(result.getMember().getName()).isEqualTo(MEMBER1.getName());
  }

  @Test
  void testCreation_NullMember() {
    ExampleTarget result = underTest.create(SOURCE1, null);

    assertThat(result.getBirthday()).isEqualTo(SOURCE1.getBirthday());
    assertThat(result.getMember()).isNull();
  }

  @Test
  void testUpdate_Member1ToMember2() {
    ExampleTarget result = underTest.create(SOURCE1, MEMBER1);

    underTest.update(result, SOURCE2, MEMBER2);

    assertThat(result.getBirthday()).isEqualTo(SOURCE2.getBirthday());
    assertThat(result.getMember()).isNotNull();
    assertThat(result.getMember().getName()).isEqualTo(MEMBER2.getName());
  }

  @Test
  void testUpdate_NullMemberToMember2() {
    ExampleTarget result = underTest.create(SOURCE1, null);

    underTest.update(result, SOURCE2, MEMBER2);

    assertThat(result.getBirthday()).isEqualTo(SOURCE2.getBirthday());
    assertThat(result.getMember()).isNotNull();
    assertThat(result.getMember().getName()).isEqualTo(MEMBER2.getName());
  }

  @Test
  void testUpdate_Member1ToNull() {
    ExampleTarget result = underTest.create(SOURCE1, MEMBER1);

    underTest.update(result, SOURCE2, null);

    assertThat(result.getBirthday()).isEqualTo(SOURCE2.getBirthday());
    assertThat(result.getMember()).isNull();
  }

  @Test
  void testUpdateWithExplicitMapping_Member1ToMember2() {
    ExampleTarget result = underTest.create(SOURCE1, MEMBER1);

    underTest.updateWithExplicitMapping(result, SOURCE2, MEMBER2);

    assertThat(result.getBirthday()).isEqualTo(SOURCE2.getBirthday());
    assertThat(result.getMember()).isNotNull();
    assertThat(result.getMember().getName()).isEqualTo(MEMBER2.getName());
  }

  @Test
  void testUpdateWithExplicitMapping_NullMemberToMember2() {
    ExampleTarget result = underTest.create(SOURCE1, null);

    underTest.updateWithExplicitMapping(result, SOURCE2, MEMBER2);

    assertThat(result.getBirthday()).isEqualTo(SOURCE2.getBirthday());
    assertThat(result.getMember()).isNotNull();
    assertThat(result.getMember().getName()).isEqualTo(MEMBER2.getName());
  }

  @Test
  void testUpdateWithExplicitMapping_Member1ToNull() {
    ExampleTarget result = underTest.create(SOURCE1, MEMBER1);

    underTest.updateWithExplicitMapping(result, SOURCE2, null);

    assertThat(result.getBirthday()).isEqualTo(SOURCE2.getBirthday());
    assertThat(result.getMember()).isNull();
  }

  @Test
  void testUpdateWithDefaultExpression_Member1ToMember2() {
    ExampleTarget result = underTest.create(SOURCE1, MEMBER1);

    underTest.updateWithDefaultExpression(result, SOURCE2, MEMBER2);

    assertThat(result.getBirthday()).isEqualTo(SOURCE2.getBirthday());
    assertThat(result.getMember()).isNotNull();
    assertThat(result.getMember().getName()).isEqualTo(MEMBER2.getName());
  }

  @Test
  void testUpdateWithDefaultExpression_NullMemberToMember2() {
    ExampleTarget result = underTest.create(SOURCE1, null);

    underTest.updateWithDefaultExpression(result, SOURCE2, MEMBER2);

    assertThat(result.getBirthday()).isEqualTo(SOURCE2.getBirthday());
    assertThat(result.getMember()).isNotNull();
    assertThat(result.getMember().getName()).isEqualTo(MEMBER2.getName());
  }

  @Test
  void testUpdateWithDefaultExpression_Member1ToNull() {
    ExampleTarget result = underTest.create(SOURCE1, MEMBER1);

    underTest.updateWithDefaultExpression(result, SOURCE2, null);

    assertThat(result.getBirthday()).isEqualTo(SOURCE2.getBirthday());
    assertThat(result.getMember()).isNull();
  }
}
