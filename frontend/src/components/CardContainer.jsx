import ShortenerForm from "./ShortenerForm";

export default function CardContainer() {
  return (
    <div className="w-140 h-60 bg-white rounded-md border-2 border-[#6a4a13] shadow-xl/50 text-center box-border">
      <h1 className="mt-2 text-5xl text-[#513300] p-2 text-shadow-lg/20 font-bold">
        Cola Link
      </h1>
      <p className="text-[#513300] text-2xl p-2 font-semibold">
        Encurtador de Links
      </p>
      <ShortenerForm />
    </div>
  );
}
