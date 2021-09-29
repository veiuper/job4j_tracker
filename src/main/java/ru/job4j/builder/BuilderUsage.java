package ru.job4j.builder;

public class BuilderUsage {
    private Byte field1;
    private Short field2;
    private Integer field3;
    private Long field4;
    private Float field5;
    private Double field6;
    private Character field7;
    private Boolean field8;

    @Override
    public String toString() {
        return "Builder{"
                + "field1=" + field1
                + ", field2=" + field2
                + ", field3=" + field3
                + ", field4=" + field4
                + ", field5=" + field5
                + ", field6=" + field6
                + ", field7=" + field7
                + ", field8=" + field8
                + '}';
    }

    static class Builder {
        private Byte field1;
        private Short field2;
        private Integer field3;
        private Long field4;
        private Float field5;
        private Double field6;
        private Character field7;
        private Boolean field8;

        Builder buildField1(Byte field1) {
            this.field1 = field1;
            return this;
        }

        Builder buildField2(Short field2) {
            this.field2 = field2;
            return this;
        }

        Builder buildField3(Integer field3) {
            this.field3 = field3;
            return this;
        }

        Builder buildField4(Long field4) {
            this.field4 = field4;
            return this;
        }

        Builder buildField5(Float field5) {
            this.field5 = field5;
            return this;
        }

        Builder buildField6(Double field6) {
            this.field6 = field6;
            return this;
        }

        Builder buildField7(Character field7) {
            this.field7 = field7;
            return this;
        }

        Builder buildField8(Boolean field8) {
            this.field8 = field8;
            return this;
        }

        BuilderUsage build() {
            BuilderUsage builderUsage = new BuilderUsage();
            builderUsage.field1 = field1;
            builderUsage.field2 = field2;
            builderUsage.field3 = field3;
            builderUsage.field4 = field4;
            builderUsage.field5 = field5;
            builderUsage.field6 = field6;
            builderUsage.field7 = field7;
            builderUsage.field8 = field8;
            return builderUsage;
        }
    }

    public static void main(String[] args) {
        BuilderUsage builderUsage = new Builder()
                .buildField1((byte) 1)
                .buildField2((short) 2)
                .buildField3(3)
                .buildField4(4L)
                .buildField5(5F)
                .buildField6(6D)
                .buildField7('7')
                .buildField8(true)
                .build();
        System.out.println(builderUsage);
    }
}
